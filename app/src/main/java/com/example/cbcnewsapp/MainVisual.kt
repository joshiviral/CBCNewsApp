package com.example.cbcnewsapp

data class MainVisual(
    val altText: String,
    val createdAt: Long,
    val credit: String,
    val derivatives: Derivatives,
    val description: String,
    val height: Int,
    val id: Int,
    val modifiedAt: Long,
    val readableCreatedAt: String,
    val readableModifiedAt: String,
    val sourceId: String,
    val title: String,
    val type: String,
    val url: String,
    val useOriginalImage: Boolean,
    val version: String,
    val width: Int
)