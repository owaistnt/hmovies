package com.artsman.hasqvarnamovies.framework.network

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import kotlinx.serialization.json.Json
import io.ktor.client.plugins.*
import io.ktor.client.request.header
import io.ktor.http.HttpHeaders
import io.ktor.http.ContentType

import io.ktor.serialization.kotlinx.json.*

fun getKtorClient() = HttpClient(Android) {
    install(Logging){
        logger = object: Logger{
            override fun log(message: String) {
                Log.v("KTOR", message)
            }

        }
    }
    install(DefaultRequest){
        header(HttpHeaders.ContentType, ContentType.Application.Json)
    }
    install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
    }
}