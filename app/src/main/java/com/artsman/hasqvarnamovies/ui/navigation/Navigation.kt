package com.artsman.hasqvarnamovies.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun MyComposeApp(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MoviesListScreen.route){
        addMoviesList(navController = navController)
        addMoviesDetail(navController = navController)
    }
}
