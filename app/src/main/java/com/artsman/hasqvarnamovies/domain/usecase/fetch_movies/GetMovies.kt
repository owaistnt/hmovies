package com.artsman.hasqvarnamovies.domain.usecase.fetch_movies

import com.artsman.hasqvarnamovies.data.movieslist.repository.IMovieRepository
import com.artsman.hasqvarnamovies.isSuccessful

class GetMovies(private val repository: IMovieRepository) : IGetMoviesListUsecase {
    private var _page = -1
    override suspend fun invoke(page: IGetMoviesListUsecase.Page) {
        if(page == IGetMoviesListUsecase.Page.Start){
            repository.clearMovies()
        }
        _page = when(page){
            IGetMoviesListUsecase.Page.Start -> 0
            IGetMoviesListUsecase.Page.Next ->  if(_page>=0) _page + 1 else 0
        }
        val moviesResponse = repository.fetchMoviesFromAPI(_page)
        if(moviesResponse.isSuccessful()){
            moviesResponse.data?.let { if(it.isNotEmpty())repository.saveToLocal(it) }
        }
    }
}