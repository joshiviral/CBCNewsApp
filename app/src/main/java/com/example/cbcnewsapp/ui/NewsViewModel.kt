package com.example.cbcnewsapp.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.cbcnewsapp.models.NewsResponseItem
import com.example.cbcnewsapp.repository.NewsRepository
import com.example.cbcnewsapp.util.Resource
import kotlinx.coroutines.launch


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
        _breakingNews.postValue(Resource.Loading)
        val response = newsRepository.getBreakingNews(q, breakingNewsPage)
        _breakingNews.postValue(response)
    }
}