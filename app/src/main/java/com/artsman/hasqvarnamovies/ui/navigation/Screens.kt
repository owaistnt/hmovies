package com.artsman.hasqvarnamovies.ui.navigation

sealed class Screen(val route: String){
    object MoviesListScreen: Screen("movie/lists")
    object MoviesDetailScreen: Screen("movie/{movieId}")
}
