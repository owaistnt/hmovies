package com.artsman.hasqvarnamovies.data.movieslist.repository

import com.artsman.hasqvarnamovies.Resource
import com.artsman.hasqvarnamovies.data.movieslist.repository.model.Movie

interface IMovieRepository {
    suspend fun fetchMoviesFromAPI(page: Int = 0): Resource<List<Movie>>
    suspend fun saveToLocal(movies: List<Movie>)
    suspend fun clearMovies()

}