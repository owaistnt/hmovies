package com.artsman.hasqvarnamovies.framework.network

import com.artsman.hasqvarnamovies.Resource
import com.artsman.hasqvarnamovies.data.movieslist.repository.network.model.IMoviesListAPI
import com.artsman.hasqvarnamovies.data.movieslist.repository.network.model.MoviesNetworkModel
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import javax.inject.Inject

class MovieListAPI @Inject constructor(val gateway: INetworkGateway): IMoviesListAPI {
    override suspend fun invoke(apiKey: String): Resource<MoviesNetworkModel> {
        return execute {
            val response = gateway.client.get("https://api.themoviedb.org/4/list/1?api_key=$apiKey"){
                headers {
                    contentType(ContentType.parse("application/json"))
                }
            }
            println("RESPONSE: ${response.status}")
            response.body()
        }
    }
}