package com.artsman.hasqvarnamovies.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.artsman.hasqvarnamovies.presentation.movies_detail.MovieDetailViewModel
import com.artsman.hasqvarnamovies.presentation.movies_detail.States
import com.artsman.hasqvarnamovies.ui.components.LoadingView
import com.artsman.hasqvarnamovies.ui.components.MovieInfoCard
import com.artsman.hasqvarnamovies.ui.components.MoviePoster
import com.artsman.hasqvarnamovies.ui.navigation.Screen

@Composable
fun MoviesDetailScreen(viewModel: MovieDetailViewModel){
    val state: States by viewModel.onStateChanged().collectAsState(initial = States.Loading)

    when(state){
        States.Loading -> LoadingView(message = "Loading ...")
        is States.Update -> {
            val moviesViewData = (state as States.Update).moviesViewData
            Box {
                MoviePoster(poster_url = moviesViewData.poster)
                MovieInfoCard(
                    title = moviesViewData.name,
                    overview = moviesViewData.overview,
                    rating = moviesViewData.rating,
                    adult = if(moviesViewData.adult) "Yes" else "No",
                    modifier = Modifier.align(Alignment.BottomCenter)
                )
            }
        }
    }

}