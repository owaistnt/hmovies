package com.artsman.hasqvarnamovies.data.movieslist.repository

import com.artsman.hasqvarnamovies.Resource
import com.artsman.hasqvarnamovies.data.movieslist.repository.model.Movie
import com.artsman.hasqvarnamovies.presentation.movies_list.Id
import kotlinx.coroutines.flow.Flow

interface IMovieRepository {
    suspend fun fetchMoviesFromAPI(page: Int = 0): Resource<List<Movie>>
    suspend fun saveToLocal(movies: List<Movie>)
    suspend fun clearMovies()
    suspend fun getMoviesFromLocalAsync(): Flow<List<Movie>>
    suspend fun getMovieFromLocalSync(movieId: Id): Movie?
}