package com.artsman.hasqvarnamovies.presentation.movies_detail

import com.artsman.hasqvarnamovies.data.movieslist.repository.model.Movie
import com.artsman.hasqvarnamovies.domain.usecase.query_movies.IMovieDetail
import com.artsman.hasqvarnamovies.presentation.movies_list.MoviesViewData
import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.beInstanceOf
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.take

class MovieDetailViewModelTest : ExpectSpec({

    val mockQueryUsecase = mockk<IMovieDetail>( relaxed = true)
    val fakeId = 1234L

    suspend fun Flow<States>.value(scope: CoroutineScope): States {
        return this.take(1).stateIn(scope).value
    }

    beforeEach {
        coEvery { mockQueryUsecase.invoke(any()) } returns Movie(fakeId.toInt(), "abc", "", "", false, rating = 12)
    }

    fun buildVM(): MovieDetailViewModel {
        return MovieDetailViewModel(mockQueryUsecase)
    }
    expect("On Start Action it must get detail of Given user"){
        val vm = buildVM()
        vm.add(Actions.Start(fakeId))
        coVerify {
            mockQueryUsecase.invoke(fakeId)
        }
        vm.onStateChanged().value(this) should beInstanceOf(States.Update::class)
        (vm.onStateChanged().value(this) as States.Update).let {
            it.moviesViewData shouldBe MoviesViewData(1234, "abc", "SSS",  12, "abc", false)
        }
    }

})
