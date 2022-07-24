package com.artsman.hasqvarnamovies.ui.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.artsman.hasqvarnamovies.presentation.movies_list.Actions
import com.artsman.hasqvarnamovies.presentation.movies_list.MoviesListViewModel
import com.artsman.hasqvarnamovies.ui.screens.MoviesListScreen

fun NavGraphBuilder.addMoviesList(navController: NavController) {
    this.composable(route = Screen.MoviesListScreen.route) {
        val listViewModel = hiltViewModel<MoviesListViewModel>()
        listViewModel.add(Actions.Start)
        MoviesListScreen(viewModel = listViewModel){
            navController.navigate(Screen.MoviesDetailScreen.route)
        }
    }
}
