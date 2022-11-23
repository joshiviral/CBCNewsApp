package com.example.cbcnewsapp

import androidx.room.Entity

data class Content(
    val author: AuthorXX,
    val authors: List<AuthorXXX>,
    val categories: List<String>,
    val categorization: Categorization,
    val deck: String,
    val departments: List<Department>,
    val description: String,
    val embeddedtypes: String,
    val epoch: Epoch,
    val extattrib: Extattrib,
    val flag: String,
    val headline: String,
    val headlineimage: Headlineimage,
    val headlinemedia: Headlinemedia,
    val id: String,
    val intlinks: List<Intlink>,
    val jsonurl: String,
    val label: String,
    val language: String,
    val lastupdate: String,
    val pubdate: String,
    val shareheadline: String,
    val show: String,
    val status: String,
    val title: String,
    val type: String,
    val url: String
)