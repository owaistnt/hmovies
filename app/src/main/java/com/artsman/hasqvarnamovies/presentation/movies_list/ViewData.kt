package com.artsman.hasqvarnamovies.presentation.movies_list

data class ViewData(val movies: List<MoviesViewData>)

typealias Link = String
typealias Rating = Long
typealias Id = Long

data class MoviesViewData(val id : Id , val name: String, val poster: Link, val rating: Rating, val overview: String, val adult: Boolean) {

}