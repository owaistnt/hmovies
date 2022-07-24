package com.artsman.hasqvarnamovies.di

import com.artsman.hasqvarnamovies.data.movieslist.repository.AppCoroutineDispatchers
import com.artsman.hasqvarnamovies.data.movieslist.repository.IMovieRepository
import com.artsman.hasqvarnamovies.data.movieslist.repository.MovieRepository
import com.artsman.hasqvarnamovies.domain.usecase.fetch_movies.GetMovies
import com.artsman.hasqvarnamovies.domain.usecase.fetch_movies.IGetMoviesListUsecase
import com.artsman.hasqvarnamovies.domain.usecase.query_movies.IMovieQueryUseCase
import com.artsman.hasqvarnamovies.domain.usecase.query_movies.QueryMovies
import com.artsman.hasqvarnamovies.framework.database.RoomAppDatabase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
class ActivityModule {



}