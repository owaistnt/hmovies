package com.artsman.hasqvarnamovies.framework.network

import io.ktor.client.*

interface INetworkGateway {
    val client: HttpClient
}