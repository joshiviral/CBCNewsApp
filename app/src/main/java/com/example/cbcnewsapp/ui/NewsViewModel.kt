package com.example.cbcnewsapp.ui

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.ConnectivityManager.*
import android.net.NetworkCapabilities.*
import android.os.Build
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.cbcnewsapp.NewsApplication
import com.example.cbcnewsapp.models.NewsResponseItem
import com.example.cbcnewsapp.repository.NewsRepository
import com.example.cbcnewsapp.util.Resource
import kotlinx.coroutines.launch
import java.io.IOException
import kotlin.reflect.typeOf


class NewsViewModel(
    app: Application,
    val newsRepository: NewsRepository
) : AndroidViewModel(app) {

    var breakingNewsPage = 1
    var _breakingNews: MutableLiveData<Resource<List<NewsResponseItem>>> = MutableLiveData()
    val breakingNews: LiveData<Resource<List<NewsResponseItem>>> = _breakingNews

    init {
        getBreakingNews("Breaking News")
    }

    fun getBreakingNews(q: String) = viewModelScope.launch {
        safeBreakingnewsCall(q)
    }

    private suspend fun safeBreakingnewsCall(q: String) {
        breakingNewsPage++
        _breakingNews.postValue(Resource.Loading)
        try {
            if (hasInternetConnection()) {
                val response = newsRepository.getBreakingNews(q, breakingNewsPage)
                _breakingNews.postValue(response)
            } else {
                _breakingNews.postValue(Resource.Error("No Internet Connection"))
            }

        } catch (t: Throwable) {
            when (t) {
                is IOException -> _breakingNews.postValue(Resource.Error("Network Failure"))
                else -> _breakingNews.postValue(Resource.Error("Conversion Error"))
            }

        }
    }
// Network Connectivity Error or Failure part being handled with this logic
    private fun hasInternetConnection(): Boolean {
        val connectivityManager = getApplication<NewsApplication>().getSystemService(
            Context.CONNECTIVITY_SERVICE
        ) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val activeNetwork = connectivityManager.activeNetwork ?: return false
            val capabilities =
                connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false
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