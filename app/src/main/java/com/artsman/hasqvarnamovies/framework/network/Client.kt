package com.artsman.hasqvarnamovies.framework.network

import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.logging.*

fun getKtorClient() = HttpClient(Android) {
    install(Logging)
}