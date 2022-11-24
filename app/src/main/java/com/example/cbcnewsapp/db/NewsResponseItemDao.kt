package com.example.cbcnewsapp.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.cbcnewsapp.models.NewsResponseItem

@Dao
interface NewsResponseItemtDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(newsResponseItem: NewsResponseItem):Long

    @Query("SELECT * FROM content")
    //Live data is class of Android Architecture components which is used to notify the changes happening in Database
    fun getAllNewsResponseItem():LiveData<List<NewsResponseItem>>

    @Delete
    suspend fun deleteNewsResponseItem(newsResponseItem: NewsResponseItem)
}