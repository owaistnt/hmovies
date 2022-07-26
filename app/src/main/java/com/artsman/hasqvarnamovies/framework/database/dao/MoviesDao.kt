package com.artsman.hasqvarnamovies.framework.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.artsman.hasqvarnamovies.framework.database.entities.MoviesDatabaseModel
import com.artsman.hasqvarnamovies.presentation.movies_list.Id
import kotlinx.coroutines.flow.Flow

@Dao
interface MoviesDao {
    @Query("SELECT * FROM movies")
    fun getAll(): List<MoviesDatabaseModel>

    @Query("SELECT * FROM movies where uid = :id")
    fun getById(id: Id): MoviesDatabaseModel

    @Query("SELECT * FROM movies")
    fun getAllAsync(): Flow<List<MoviesDatabaseModel>>

    @Query("SELECT * FROM movies WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<MoviesDatabaseModel>


    @Insert
    fun insertAll(vararg movies: MoviesDatabaseModel)

    @Delete
    fun delete(user: MoviesDatabaseModel)
}
