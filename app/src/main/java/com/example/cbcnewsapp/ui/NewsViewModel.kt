package com.example.cbcnewsapp.ui

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.ConnectivityManager.*
import android.net.NetworkCapabilities.*
import android.os.Build
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cbcnewsapp.Content
import com.example.cbcnewsapp.NewsApplication
import com.example.cbcnewsapp.api.RetrofitInstance
import com.example.cbcnewsapp.models.NewsResponse
import com.example.cbcnewsapp.repository.NewsRepository
import com.example.cbcnewsapp.util.Resource
import kotlinx.coroutines.launch
import retrofit2.Response
import java.io.IOException

class NewsViewModel(
    app: Application,
    val newsRepository: NewsRepository
) : AndroidViewModel(app) {


    val breakingNews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    var breakingNewsPage = 1

    init {
        getBreakingNews("Breaking News")
    }


    fun getBreakingNews(q: String) = viewModelScope.launch {
        breakingNews.postValue(Resource.Loading())


    }

    private fun handleBreakingNewsResponse(response: Response<NewsResponse>): Resource<NewsResponse> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }


    private suspend fun safeBreakingnewsCall(q: String) {
        breakingNews.postValue(Resource.Loading())
        try {
            if(hasInternetConnection()) {
                val response = newsRepository.getBreakingNews(q, breakingNewsPage)
                breakingNews.postValue(handleBreakingNewsResponse(response))
            }else{
                breakingNews.postValue(Resource.Error("No Internet Connection"))
            }        } catch (t: Throwable) {
            when(t){
                is IOException -> breakingNews.postValue(Resource.Error("Network Failure"))
                else -> breakingNews.postValue(Resource.Error("Conversion Error"))
            }

        }
    }


    //to check whether the user is connected to internet or not

     private fun hasInternetConnection(): Boolean {

         val connectivityManager =
             getApplication<NewsApplication>().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
         if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
             val activenetwork = connectivityManager.activeNetwork ?: return false
             val capabilities =
                 connectivityManager.getNetworkCapabilities(activenetwork) ?: return false

             return when {
                 capabilities.hasTransport(TRANSPORT_WIFI) -> true
                 capabilities.hasTransport(TRANSPORT_CELLULAR) -> true
                 capabilities.hasTransport(TRANSPORT_ETHERNET) -> true

                 else -> false
             }

         } else {
             connectivityManager.activeNetworkInfo?.run {
                 return when (type) {
                     TYPE_WIFI -> true
                     TYPE_MOBILE -> true
                     TYPE_ETHERNET -> true
                     else -> false
                 }
             }

         }
         return false
     }

}