package com.artsman.hasqvarnamovies.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.artsman.hasqvarnamovies.presentation.movies_list.Id
import com.artsman.hasqvarnamovies.presentation.movies_list.MoviesListViewModel
import com.artsman.hasqvarnamovies.presentation.movies_list.MoviesViewData
import com.artsman.hasqvarnamovies.presentation.movies_list.States
import com.artsman.hasqvarnamovies.ui.components.LoadingView
import com.artsman.hasqvarnamovies.ui.components.MovieCard
import com.artsman.hasqvarnamovies.ui.components.SimpleListItem

@Composable
fun MoviesListScreen(viewModel: MoviesListViewModel, onItemClicked: (id: Id)-> Unit) {
    val state: States by viewModel.onStateChanged().collectAsState(initial = States.Loading)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Top Movies")
                }
            )
        }
    ) {
        when(state){
            States.Loading -> LoadingView(modifier = Modifier.fillMaxSize(), message = "Setting Up...")
            is States.Update -> MoviesListComponent((state as States.Update).viewData.movies)
        }

    }
}

@Composable
fun MoviesListComponent(movies: List<MoviesViewData>) {
    LazyColumn{
        items(movies, key = {movie -> movie.id}){ m ->
            MovieCard(title = m.name, poster_url = m.poster)
        }
    }
}