package com.artsman.hasqvarnamovies.ui.navigation

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.artsman.hasqvarnamovies.presentation.movies_list.Actions
import com.artsman.hasqvarnamovies.presentation.movies_list.MoviesListViewModel
import com.artsman.hasqvarnamovies.ui.screens.MoviesListScreen
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.artsman.hasqvarnamovies.presentation.movies_detail.MovieDetailViewModel
import com.artsman.hasqvarnamovies.ui.screens.MoviesDetailScreen


fun NavGraphBuilder.addMoviesList(navController: NavController) {
    this.composable(route = Screen.MoviesListScreen.route) {
        var isVMStarted by remember {
            mutableStateOf<Boolean>(false)
        }
        val listViewModel = hiltViewModel<MoviesListViewModel>()
        if(!isVMStarted){
            listViewModel.add(Actions.Start)
            isVMStarted = true
        }
        Log.d("Nav", "AddMoviesList: Start")
        MoviesListScreen(viewModel = listViewModel){
            navController.navigate("movie/$it")
        }
    }
}

fun NavGraphBuilder.addMoviesDetail(navController: NavController) {
    this.composable(route = Screen.MoviesDetailScreen.route,
    arguments = listOf(
        navArgument("movieId") {
            type = NavType.LongType
        },
    )) {
        val movieId = it.arguments?.getLong("movieId")
        var isVMStarted by remember {
            mutableStateOf<Boolean>(false)
        }
        val listViewModel = hiltViewModel<MovieDetailViewModel>()
        movieId?.let { id ->
            if(!isVMStarted){
                listViewModel.add(com.artsman.hasqvarnamovies.presentation.movies_detail.Actions.Start(id))
                isVMStarted = true
            }
        }
        Log.d("Nav", "AddMoviesList: Start")
        MoviesDetailScreen(viewModel = listViewModel)
    }
}
