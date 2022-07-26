package com.artsman.hasqvarnamovies.domain.usecase.query_movies

import com.artsman.hasqvarnamovies.data.movieslist.repository.IMovieRepository
import io.kotest.core.spec.style.ExpectSpec
import io.mockk.coVerify
import io.mockk.mockk
import io.mockk.verify

class MovieDetailQueryTest : ExpectSpec({


    val fakeMovieId = 1234L
    val repo = mockk<IMovieRepository>(relaxed = true)
    fun buildUseCase(): MovieDetailQuery {
        return MovieDetailQuery(repo)
    }
    expect("Given a movie Id it must get movie detail from repository"){
        val usecase = buildUseCase()
        usecase.invoke(fakeMovieId)
        coVerify {
            repo.getMovieFromLocalSync(fakeMovieId)
        }
    }
})
