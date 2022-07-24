package com.artsman.hasqvarnamovies.data.movieslist.repository

import androidx.room.RoomDatabase
import com.artsman.hasqvarnamovies.Resource
import com.artsman.hasqvarnamovies.Status
import com.artsman.hasqvarnamovies.data.movieslist.repository.mappers.toDatabaseModel
import com.artsman.hasqvarnamovies.data.movieslist.repository.mappers.toDomainModel
import com.artsman.hasqvarnamovies.data.movieslist.repository.model.Movie
import com.artsman.hasqvarnamovies.framework.database.RoomAppDatabase
import com.artsman.hasqvarnamovies.successful
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.map

class MovieRepository(private val roomDatabase: RoomAppDatabase) : IMovieRepository{


    override suspend fun fetchMoviesFromAPI(page: Int): Resource<List<Movie>> {
        return Resource(data = listOf(Movie(1, "Jab We Met", null)), status = Status.Success, error = null)
    }

    override suspend fun saveToLocal(movies: List<Movie>) {
        val moviesForDb = movies.map { it.toDatabaseModel() }
        roomDatabase.moviesDao().insertAll(*moviesForDb.toTypedArray())
    }

    override suspend fun clearMovies() {
        roomDatabase.runInTransaction {
            val allMovies = roomDatabase.moviesDao().getAll()
            allMovies.forEach {
                roomDatabase.moviesDao().delete(it)
            }
        }
    }

    override suspend fun getMoviesFromLocalAsync(): Flow<List<Movie>> {
        return roomDatabase.moviesDao().getAllAsync().map { list -> list.map { it.toDomainModel() } }
    }
}