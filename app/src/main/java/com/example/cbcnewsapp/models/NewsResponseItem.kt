package com.example.cbcnewsapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey

// This Entity annotation tells that this class is Table in Database
@Entity(
    tableName = "content"
)

data class NewsResponseItem(
    @PrimaryKey(autoGenerate = true)
    var id: Int?=null,
    val active: Boolean,
    val description: String,
    val images: Images,
    val language: String,
    val publishedAt: Long,
    val readablePublishedAt: String,
    val readableUpdatedAt: String,
    val title: String,
    val type: String,
    val updatedAt: Long,
    val version: String
)