package com.example.cbcnewsapp.repository

import com.example.cbcnewsapp.api.RetrofitInstance
import com.example.cbcnewsapp.db.NewsResponseItemDatabase

class NewsRepository(
    val db: NewsResponseItemDatabase
) {
    suspend fun getBreakingNews(q: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(q, pageNumber)
}