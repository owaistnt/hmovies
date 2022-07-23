package com.artsman.hasqvarnamovies.domain.usecase

import com.artsman.hasqvarnamovies.data.movieslist.repository.IMovieRepository
import com.artsman.hasqvarnamovies.data.movieslist.repository.model.Movie
import com.artsman.hasqvarnamovies.domain.usecase.fetch_movies.GetMovies
import com.artsman.hasqvarnamovies.domain.usecase.fetch_movies.IGetMoviesListUsecase
import com.artsman.hasqvarnamovies.successful
import com.artsman.hasqvarnamovies.unSuccessful
import io.kotest.core.spec.style.ExpectSpec
import io.mockk.*

class GetMoviesListUseCaseTest : ExpectSpec({

    val repository = mockk<IMovieRepository>(relaxed = true)
    val mockMovie = mockk<List<Movie>>(relaxed = true)

    beforeEach {
        coEvery { repository.fetchMoviesFromAPI() } returns successful(mockMovie)
        coEvery { repository.saveToLocal(any()) } returns Unit
    }

    afterEach {
        clearMocks(repository)
    }

    fun buildUsecase(): GetMovies {
        return GetMovies(repository)
    }
    expect("It must get list from API and Save in Database"){
        buildUsecase().invoke(IGetMoviesListUsecase.Page.Start)
        coVerify {
            repository.fetchMoviesFromAPI(page = 0)
            repository.saveToLocal(mockMovie)
        }
    }

    expect("Given error fetching profile It must not save in Database"){
        coEvery { repository.fetchMoviesFromAPI() } returns unSuccessful()

        buildUsecase().invoke(IGetMoviesListUsecase.Page.Start)
        coVerify {
            repository.fetchMoviesFromAPI(page = 0)
        }

        coVerify(inverse = true) {
            repository.saveToLocal(any())
        }
    }

    expect("Given empty list fetching profile It must not save in Database"){
        coEvery { repository.fetchMoviesFromAPI() } returns successful(emptyList())
        buildUsecase().invoke(IGetMoviesListUsecase.Page.Start)
        coVerify {
            repository.fetchMoviesFromAPI(page = 0)
        }

        coVerify(inverse = true) {
            repository.saveToLocal(any())
        }
    }

    expect("Given Next Page it must increment page number"){
        val usecase = buildUsecase()
        usecase.invoke(IGetMoviesListUsecase.Page.Start)
        usecase.invoke(IGetMoviesListUsecase.Page.Next)
        usecase.invoke(IGetMoviesListUsecase.Page.Next)
        coVerify {
            repository.fetchMoviesFromAPI(page = 2)
            repository.saveToLocal(mockMovie)
        }
    }

    expect("Given Start after any number of Next Page it must load page 0"){
        val usecase = buildUsecase()
        usecase.invoke(IGetMoviesListUsecase.Page.Start)
        usecase.invoke(IGetMoviesListUsecase.Page.Next)
        usecase.invoke(IGetMoviesListUsecase.Page.Next)
        usecase.invoke(IGetMoviesListUsecase.Page.Start)

        coVerify {
            repository.fetchMoviesFromAPI(page = 0)
            repository.saveToLocal(mockMovie)
        }
    }

    expect("It must clear data on start"){
        val usecase = buildUsecase()
        usecase.invoke(IGetMoviesListUsecase.Page.Start)
        coVerify() {
            repository.clearMovies()
        }
    }

})
