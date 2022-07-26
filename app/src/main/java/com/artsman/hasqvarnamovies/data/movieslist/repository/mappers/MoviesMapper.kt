package com.artsman.hasqvarnamovies.data.movieslist.repository.mappers

import com.artsman.hasqvarnamovies.data.movieslist.repository.model.Movie
import com.artsman.hasqvarnamovies.data.movieslist.repository.network.model.MoviesNetworkModel
import com.artsman.hasqvarnamovies.framework.database.entities.MoviesDatabaseModel

fun MoviesNetworkModel.toDatabaseModel(): List<MoviesDatabaseModel> {
    return this.results.map {
        MoviesDatabaseModel(uid = it.id, name =  it.original_title, poster = it.poster_path.decorateLink(), rating = it.vote_average.toLong(), overview = it.overview, adult = it.adult)
    }
}


fun MoviesNetworkModel.toDomainModel(): List<Movie> {
    return this.results.map {
        Movie(id = it.id, name =  it.original_title, poster = it.poster_path.decorateLink(), overview = it.overview, adult = it.adult, rating = it.vote_average.toLong())
    }
}

fun MoviesDatabaseModel.toDomainModel(): Movie {
    return Movie(id = this.uid, name = this.name?: "", poster = this.poster, overview = this.overview ?: "", adult = this.adult ?: false, rating = this.rating ?: 0)
}

fun Movie.toDatabaseModel(): MoviesDatabaseModel {
    return MoviesDatabaseModel(uid = this.id, name = this.name?: "", poster = this.poster, rating = 0, overview = this.overview, adult = this.adult )//todo rating
}

private fun String.decorateLink(): String {
    return "https://image.tmdb.org/t/p/w500/$this"
}