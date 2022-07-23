package com.artsman.hasqvarnamovies.domain.usecase.query_movies

import com.artsman.hasqvarnamovies.data.movieslist.repository.IMovieRepository
import io.kotest.core.spec.style.ExpectSpec
import io.mockk.coVerify
import io.mockk.mockk

class QueryMoviesTest : ExpectSpec({

    val repository = mockk<IMovieRepository>(relaxed = true)
    fun  buildUseCase() = QueryMovies(repository)
    expect("it must get movies list from repository"){
        buildUseCase().invoke()
        coVerify {
            repository.getMoviesFromLocalAsync()
        }
    }
})
