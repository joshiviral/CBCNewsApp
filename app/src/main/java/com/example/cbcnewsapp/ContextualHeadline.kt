package com.example.cbcnewsapp

data class ContextualHeadline(
    val contextId: Any,
    val contextualLineupSlug: String,
    val headline: String,
    val headlineType: String,
    val pubQueueId: String
)