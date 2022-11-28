package com.example.cbcnewsapp.util

// This class is recommended by Google to be used to wrap around Network responses. Also it is very useful to differentiate between
// successful and error responses
sealed class Resource<out T> {
    object Loading : Resource<Nothing>()
    data class Success<T>(val data: T) : Resource<T>()
    data class Error<T>(val message: String) : Resource<T>()
}