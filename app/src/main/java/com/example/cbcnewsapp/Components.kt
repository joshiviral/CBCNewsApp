package com.example.cbcnewsapp

import com.example.cbcnewsapp.models.MainContent

data class Components(
    val mainContent: MainContent,
    val mainVisual: MainVisual,
    val primary: List<Primary>,
    val secondary: List<Secondary>,
    val tertiary: List<Any>
)