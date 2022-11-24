package com.example.cbcnewsapp

data class Photo(
    val alt: String,
    val credit: String,
    val deck: String,
    val description: String,
    val headline: String,
    val id: String,
    val jsonurl: String,
    val originalimage: Originalimage,
    val originalimageurl: String,
    val size: String,
    val title: String,
    val type: String,
    val url: String,
    val useoriginalimage: Boolean
)