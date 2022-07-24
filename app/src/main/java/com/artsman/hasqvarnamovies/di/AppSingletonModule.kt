package com.artsman.hasqvarnamovies.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.artsman.hasqvarnamovies.data.movieslist.repository.AppCoroutineDispatchers
import com.artsman.hasqvarnamovies.data.movieslist.repository.IMovieRepository
import com.artsman.hasqvarnamovies.data.movieslist.repository.MovieRepository
import com.artsman.hasqvarnamovies.domain.usecase.fetch_movies.GetMovies
import com.artsman.hasqvarnamovies.domain.usecase.fetch_movies.IGetMoviesListUsecase
import com.artsman.hasqvarnamovies.domain.usecase.query_movies.IMovieQueryUseCase
import com.artsman.hasqvarnamovies.domain.usecase.query_movies.QueryMovies
import com.artsman.hasqvarnamovies.framework.database.RoomAppDatabase
import com.artsman.hasqvarnamovies.framework.database.buildDatabase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppSingletonModule {

    @Singleton
    @Provides
    fun providesRoomDatabase(@ApplicationContext context: Context): RoomAppDatabase {
        return buildDatabase(context)
    }

    @Singleton
    @Provides
    fun bindGetMovies(repo: IMovieRepository): IGetMoviesListUsecase{
        return GetMovies(repo)
    }

    @Singleton
    @Provides
    fun bindMoviesRepository(database: RoomAppDatabase, dispatchers: AppCoroutineDispatchers): IMovieRepository{
        return MovieRepository(roomDatabase = database, dispatchers = dispatchers)
    }


    @Provides
    fun providesQueryMovies(repository: IMovieRepository): IMovieQueryUseCase {
        return QueryMovies(repository)
    }

    @Provides
    fun providesAppCoroutineDispatchers(): AppCoroutineDispatchers{
        return AppCoroutineDispatchers(
            io = Dispatchers.IO,
            main = Dispatchers.Main,
            default = Dispatchers.Default,
            mainImmediate = Dispatchers.Main.immediate
        )
    }
}