package com.example.data.network

import com.example.domain.network.NetworkService
import io.ktor.client.HttpClient

// This file will includes all implementation endpoints or endpoints to be called
class NetworkServiceImpl(private val httpClient: HttpClient) : NetworkService {
    override suspend fun getProducts() {
        TODO("Not yet implemented")
    }
}