package com.example.tilsit9.presentation

sealed class Status<out T> {
    class Loading<out T> : Status<T>()
    data class Success<out T>(val data: T) : Status<T>()
    data class Failure<out T>(val throwable: Throwable) : Status<T>()
}