package com.example.cbcnewsapp.util

// This class is recommended by Google to be used to wrap around Network responses. Also it is very useful to differentiate between
// successful and error responses
sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T):Resource<T>(data)
    class Error<T>(message: String,data: T?=null):Resource<T>(data, message)
    class Loading<T>:Resource<T>()

}