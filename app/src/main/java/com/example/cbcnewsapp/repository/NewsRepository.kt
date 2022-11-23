package com.example.cbcnewsapp.repository

import com.example.cbcnewsapp.api.RetrofitInstance
import com.example.cbcnewsapp.db.MainContentDatabase

class NewsRepository(
    val db: MainContentDatabase
) {
    suspend fun getBreakingNews(q: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(q, pageNumber)
}