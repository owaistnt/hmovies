package com.artsman.hasqvarnamovies.presentation.movies_detail

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.artsman.hasqvarnamovies.domain.usecase.fetch_movies.IGetMoviesListUsecase
import com.artsman.hasqvarnamovies.domain.usecase.query_movies.IMovieDetail
import com.artsman.hasqvarnamovies.presentation.BaseViewModel
import com.artsman.hasqvarnamovies.presentation.movies_list.MoviesViewData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(val queryUsecase: IMovieDetail) : BaseViewModel<Actions, States, Events>() {
    override var initalState: States
        get() = States.Loading
        set(value) {}

    override fun add(action: Actions) {
        when(action){
           is  Actions.Start -> viewModelScope.launch {
               val movie = queryUsecase.invoke(action.movieId)
               movie?.let {
                   val movieData = MoviesViewData( id = it.id.toLong(), name = it.name, overview = it.overview, poster = it.poster ?: "", adult = it.adult, rating = it.rating)//todo move to mapping file
                   sendState(States.Update(movieData))
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
}


sealed class Actions{
    data class Start(val movieId: Long): Actions()
}

sealed class States{
    object Loading : States()
    data class Update(val moviesViewData: MoviesViewData) : States()
}

sealed class Events{

}

data class ViewData(val movies: MoviesViewData)
