package com.artsman.hasqvarnamovies.presentation.movies_list

sealed class States{
    object Loading: States()
    data class Update(val viewData: ViewData): States()
}