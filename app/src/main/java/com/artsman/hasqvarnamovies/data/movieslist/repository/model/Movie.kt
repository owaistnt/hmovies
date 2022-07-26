package com.artsman.hasqvarnamovies.data.movieslist.repository.model

import com.artsman.hasqvarnamovies.presentation.movies_list.Rating

data class Movie(val id: Int, val name: String, val poster: String?, val overview: String, val adult: Boolean, val rating: Rating)
