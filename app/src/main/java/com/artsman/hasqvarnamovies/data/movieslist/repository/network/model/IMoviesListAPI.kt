package com.artsman.hasqvarnamovies.data.movieslist.repository.network.model

import com.artsman.hasqvarnamovies.Resource

interface IMoviesListAPI {
    suspend fun invoke(apiKey: String): Resource<MoviesNetworkModel>
}