package com.example.flavorsdemo.comman

sealed class Resource<out T> {
    object Pending : Resource<Nothing>()
    data class Error(val error: Throwable) : Resource<Nothing>()
    data class Success<T>(val data: T) : Resource<T>()
}

