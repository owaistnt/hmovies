package com.artsman.hasqvarnamovies.domain.usecase.query_movies

import com.artsman.hasqvarnamovies.data.movieslist.repository.IMovieRepository
import com.artsman.hasqvarnamovies.data.movieslist.repository.model.Movie
import com.artsman.hasqvarnamovies.presentation.movies_list.Id
import javax.inject.Inject

class MovieDetailQuery @Inject constructor(val repo: IMovieRepository) : IMovieDetail {
    override suspend fun invoke(movieId: Id): Movie? {
        return repo.getMovieFromLocalSync(movieId)
    }
}