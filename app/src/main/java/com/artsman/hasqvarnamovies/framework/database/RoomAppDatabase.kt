package com.artsman.hasqvarnamovies.framework.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.artsman.hasqvarnamovies.framework.database.dao.MoviesDao
import com.artsman.hasqvarnamovies.framework.database.entities.MoviesDatabaseModel

@Database(entities = [MoviesDatabaseModel::class], version = 1)
abstract class RoomAppDatabase : RoomDatabase() {
    abstract fun moviesDao(): MoviesDao
}


fun buildDatabase(context: Context): RoomAppDatabase {
    return  Room.databaseBuilder(
        context,
        RoomAppDatabase::class.java, "hmovies"
    ).build()

}