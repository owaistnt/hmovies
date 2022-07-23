package com.artsman.hasqvarnamovies.domain.usecase

import com.artsman.hasqvarnamovies.data.movieslist.repository.IMovieRepository
import com.artsman.hasqvarnamovies.isSuccessful

class GetMoviesListUseCase(private val repository: IMovieRepository) : IGetMoviesList {
    private var _page = -1
    override suspend fun invoke(page: IGetMoviesList.Page) {
        if(page == IGetMoviesList.Page.Start){
            repository.clearMovies()
        }
        _page = when(page){
            IGetMoviesList.Page.Start -> 0
            IGetMoviesList.Page.Next ->  if(_page>=0) _page + 1 else 0
        }
        val moviesResponse = repository.fetchMoviesFromAPI(_page)
        if(moviesResponse.isSuccessful()){
            moviesResponse.data?.let { if(it.isNotEmpty())repository.saveToLocal(it) }
        }
    }
}