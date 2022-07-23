package com.artsman.hasqvarnamovies.domain.usecase

interface IGetMoviesList {
    suspend operator fun invoke(page: Page)
    enum class Page{
        Start, Next
    }
}