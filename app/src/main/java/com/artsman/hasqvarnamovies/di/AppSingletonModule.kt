package com.artsman.hasqvarnamovies.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.artsman.hasqvarnamovies.framework.database.buildDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppSingletonModule {

    @Singleton
    @Provides
    fun providesRoomDatabase(@ApplicationContext context: Context): RoomDatabase {
        return buildDatabase(context)
    }

}