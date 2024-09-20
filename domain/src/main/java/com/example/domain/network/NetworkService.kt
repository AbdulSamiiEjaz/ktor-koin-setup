package com.example.domain.network

import java.lang.Exception

// This will be used to define which endpoints to implement in data module in NetworkService Impl
interface NetworkService {
    suspend fun getProducts()
}

sealed class ResultWrapper<out T> {
    data class Success<out T>(val value: T) : ResultWrapper<T>()
    data class Failure(val exception: Exception) : ResultWrapper<Nothing>()
}