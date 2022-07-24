package com.artsman.hasqvarnamovies.di

import com.artsman.hasqvarnamovies.domain.usecase.fetch_movies.GetMovies
import com.artsman.hasqvarnamovies.domain.usecase.fetch_movies.IGetMoviesListUsecase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface AppInterfaceModule {

    @Singleton
    @Binds
    fun bindGetMovies(getMovies: GetMovies): IGetMoviesListUsecase

}