package com.artsman.hasqvarnamovies.data.movieslist.repository

import androidx.room.RoomDatabase
import com.artsman.hasqvarnamovies.Resource
import com.artsman.hasqvarnamovies.Status
import com.artsman.hasqvarnamovies.data.movieslist.repository.mappers.toDatabaseModel
import com.artsman.hasqvarnamovies.data.movieslist.repository.mappers.toDomainModel
import com.artsman.hasqvarnamovies.data.movieslist.repository.model.Movie
import com.artsman.hasqvarnamovies.data.movieslist.repository.network.model.IMoviesListAPI
import com.artsman.hasqvarnamovies.framework.database.RoomAppDatabase
import com.artsman.hasqvarnamovies.successful
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieRepository @Inject constructor(private val movieAPI: IMoviesListAPI, private val roomDatabase: RoomAppDatabase, private val dispatchers: AppCoroutineDispatchers) : IMovieRepository{


    override suspend fun fetchMoviesFromAPI(page: Int): Resource<List<Movie>> {
        //return Resource(data = listOf(Movie(1, "Jab We Met", null)), status = Status.Success, error = null)

        val response =  movieAPI.invoke("a3d8be61ee48c0397fa469573112b190")
        return Resource(response.data?.toDomainModel(), status = response.status, error = response.error)
    }

    override suspend fun saveToLocal(movies: List<Movie>) {
        withContext(dispatchers.io){
            val moviesForDb = movies.map { it.toDatabaseModel() }
            roomDatabase.moviesDao().insertAll(*moviesForDb.toTypedArray())
        }
    }

    override suspend fun clearMovies() {
        withContext(dispatchers.io){
            roomDatabase.runInTransaction {
                val allMovies = roomDatabase.moviesDao().getAll()
                allMovies.forEach {
                    roomDatabase.moviesDao().delete(it)
                }
            }
        }
    }

    override suspend fun getMoviesFromLocalAsync(): Flow<List<Movie>> {
        return withContext(dispatchers.io){
            return@withContext roomDatabase.moviesDao().getAllAsync().map { list -> list.map { it.toDomainModel() } }
        }
    }
}