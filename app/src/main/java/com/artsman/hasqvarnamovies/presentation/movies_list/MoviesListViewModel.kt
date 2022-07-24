package com.artsman.hasqvarnamovies.presentation.movies_list

import androidx.lifecycle.viewModelScope
import com.artsman.hasqvarnamovies.data.movieslist.repository.model.Movie
import com.artsman.hasqvarnamovies.domain.usecase.fetch_movies.IGetMoviesListUsecase
import com.artsman.hasqvarnamovies.domain.usecase.query_movies.IMovieQueryUseCase
import com.artsman.hasqvarnamovies.presentation.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesListViewModel  @Inject constructor(private val getMovies: IGetMoviesListUsecase, private val queryMovies: IMovieQueryUseCase): BaseViewModel<Actions, States,Events >() {
    override var initalState: States
        get() = States.Loading
        set(value) {}


    override fun add(action: Actions) {
        when(action){
            Actions.Start -> viewModelScope.launch {
                getMovies.invoke(IGetMoviesListUsecase.Page.Start)
                queryMovies.invoke().collect {
                    val movieViewData = it.mapToViewData()
                    println("Movies: $movieViewData")
                    sendState(States.Update(ViewData(movieViewData)))
                }
            }
        }
    }

    override fun onStateChanged(): Flow<States> {
        return stateHolder
    }

    override fun onEvents(): Flow<Events?> {
        TODO("Not yet implemented")
    }

    private fun List<Movie>.mapToViewData(): List<MoviesViewData> {
        return this.map {
            MoviesViewData(id = it.id.toLong(), name = it.name, poster = "", rating = 0)
        }
    }
}




