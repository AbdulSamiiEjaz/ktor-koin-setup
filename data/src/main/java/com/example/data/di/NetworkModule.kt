package com.example.data.di

import com.example.data.network.NetworkServiceImpl
import com.example.domain.network.NetworkService
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

// Include this module in DataModule like barron export in js
val networkModule = module {
    single { // Default config for ktor client
        HttpClient(CIO) {
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }
            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        println("KTOR LOG:: $message")
                    }
                }
                level = LogLevel.ALL
            }

        }
    }

    single<NetworkService> {
        NetworkServiceImpl(get())
    }
}