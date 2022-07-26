package com.artsman.hasqvarnamovies.domain.usecase.query_movies

import com.artsman.hasqvarnamovies.data.movieslist.repository.model.Movie
import com.artsman.hasqvarnamovies.presentation.movies_list.Id

interface IMovieDetail {
    suspend fun invoke(movieId: Id): Movie?
}