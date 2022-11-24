package com.example.cbcnewsapp.api

import com.example.cbcnewsapp.models.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
// API interface which will define single request executed from the code
interface NewsApi {

    // Get request from API
    @GET("aggregate_api/v1/items")
    // This function is used to get all the breaking news from the API
    suspend fun getBreakingNews(

        @Query("q")
        searchQuery: String,

        @Query("page")
        pageNumber: Int = 1
    ): Response<NewsResponse>


}