package com.example.cbcnewsapp.api

import com.example.cbcnewsapp.models.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("aggregate_api/v1/items")
    suspend fun getBreakingNews(

        @Query("q")
        searchQuery: String,

        @Query("page")
        pageNumber: Int = 1
    ): Response<NewsResponse>


}