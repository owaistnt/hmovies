package com.artsman.hasqvarnamovies.domain.usecase.query_movies

import com.artsman.hasqvarnamovies.data.movieslist.repository.model.Movie
import kotlinx.coroutines.flow.Flow

interface IMovieQueryUseCase {
    suspend fun invoke(): Flow<List<Movie>>
}