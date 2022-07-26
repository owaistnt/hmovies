@file:OptIn(ExperimentalCoroutinesApi::class)

package com.artsman.hasqvarnamovies.presentation.movies_list

import com.artsman.hasqvarnamovies.data.movieslist.repository.model.Movie
import com.artsman.hasqvarnamovies.domain.usecase.fetch_movies.IGetMoviesListUsecase
import com.artsman.hasqvarnamovies.domain.usecase.query_movies.IMovieQueryUseCase
import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.beInstanceOf
import io.kotest.matchers.types.shouldBeSameInstanceAs
import io.mockk.clearMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.setMain

class MoviesListViewModelTest : ExpectSpec({

    suspend fun Flow<States>.value(scope: CoroutineScope): States {
        return this.take(1).stateIn(scope).value
    }

    val mockGetMovies = mockk<IGetMoviesListUsecase>(relaxed = true)
    val mockQueryMovies = mockk<IMovieQueryUseCase>(relaxed = true)
    val fakeMovies = listOf<Movie>(Movie(1234, "abc", "SSS", "abc", false, rating = 12))

    beforeTest {
        Dispatchers.setMain(UnconfinedTestDispatcher())
    }
    beforeEach {
        coEvery { mockQueryMovies.invoke() } returns flowOf(fakeMovies)
    }

    afterEach {
        clearMocks(mockQueryMovies, mockGetMovies)
    }
    fun buildViewModel() = MoviesListViewModel(mockGetMovies, mockQueryMovies)

    expect("on START action it must get movies") {
        val viewModel = buildViewModel()
        viewModel.add(Actions.Start)
        coVerify(exactly = 1) {
            mockGetMovies.invoke(IGetMoviesListUsecase.Page.Start)
            mockQueryMovies.invoke()
        }
        viewModel.onStateChanged().value(this) should beInstanceOf(States.Update::class)
        (viewModel.onStateChanged().value(this) as States.Update).let {
            it.viewData.movies shouldBe listOf(MoviesViewData(1234, "abc", "SSS",  12, "abc", false))
        }
    }


})
