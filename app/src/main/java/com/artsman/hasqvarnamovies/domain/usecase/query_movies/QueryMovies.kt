package com.artsman.hasqvarnamovies.domain.usecase.query_movies

import com.artsman.hasqvarnamovies.data.movieslist.repository.IMovieRepository
import com.artsman.hasqvarnamovies.data.movieslist.repository.model.Movie
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class QueryMovies @Inject constructor(val repository: IMovieRepository) : IMovieQueryUseCase {
    override suspend fun invoke(): Flow<List<Movie>> {
        return repository.getMoviesFromLocalAsync()
    }
}