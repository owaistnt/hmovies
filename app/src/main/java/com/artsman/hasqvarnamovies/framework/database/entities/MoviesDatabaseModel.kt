package com.artsman.hasqvarnamovies.framework.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class MoviesDatabaseModel(@PrimaryKey val uid: Int,
                               @ColumnInfo(name = "name") val name: String?,
                               @ColumnInfo(name = "poster") val poster: String?,
                               @ColumnInfo(name = "rating") val rating: Long?,
)
