package com.example.cbcnewsapp

data class TypeAttributesX(
    val author: AuthorX,
    val body: BodyX,
    val categories: Any,
    val commentsSectionId: String,
    val contextualHeadlines: Any,
    val deck: String,
    val displayComments: Boolean,
    val flag: String,
    val flags: Flags,
    val headline: Headline,
    val imageAspects: String,
    val imageLarge: String,
    val imageSmall: String,
    val media: Any,
    val mediaCaptionUrl: Any,
    val mediaDuration: Any,
    val mediaId: Any,
    val mediaStreamType: Any,
    val sectionLabels: List<String>,
    val sectionList: List<String>,
    val show: String,
    val showSlug: String,
    val trending: Trending,
    val url: String,
    val urlSlug: String
)