package com.example.cbcnewsapp.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.cbcnewsapp.models.MainContent

@Dao
interface MainContentDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(mainContent: MainContent):Long

    @Query("SELECT * FROM content")
    //Live data is part of Android Architecture components which is used to notify the changes happening in Database
    fun getAllContent():LiveData<List<MainContent>>

    @Delete
    suspend fun deleteContent(mainContent: MainContent)
}