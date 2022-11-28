package com.example.cbcnewsapp.repository

import com.example.cbcnewsapp.api.RetrofitInstance
import com.example.cbcnewsapp.db.NewsResponseItemDatabase
import com.example.cbcnewsapp.models.NewsResponseItem
import com.example.cbcnewsapp.util.Resource
import retrofit2.Response

class NewsRepository(
    val db: NewsResponseItemDatabase
) {
    suspend fun getBreakingNews(q: String, pageNumber: Int): Resource<List<NewsResponseItem>> {
        val response = RetrofitInstance.api.getBreakingNews(q, pageNumber)
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }
}
