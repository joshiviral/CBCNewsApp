package com.example.cbcnewsapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cbcnewsapp.TypeAttributesX

// This Entity annotation tells that this class is Table in Database
@Entity(
    tableName = "content"
)

data class MainContent(
    @PrimaryKey(autoGenerate = true)
    val id: Int?=null,
    val active: Boolean,
    val description: String,
    val draft: Boolean,
    val embedTypes: String,
    val language: String,
    val publishedAt: Long,
    val readablePublishedAt: String,
    val readableUpdatedAt: String,
    val source: String,
    val sourceId: String,
    val title: String,
    val type: String,
    val typeAttributes: TypeAttributesX,
    val updatedAt: Long,
    val version: String
)