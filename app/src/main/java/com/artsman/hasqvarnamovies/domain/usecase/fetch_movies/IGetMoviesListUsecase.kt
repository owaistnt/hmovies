package com.artsman.hasqvarnamovies.domain.usecase.fetch_movies

interface IGetMoviesListUsecase {
    suspend operator fun invoke(page: Page)
    enum class Page{
        Start, Next
    }
}