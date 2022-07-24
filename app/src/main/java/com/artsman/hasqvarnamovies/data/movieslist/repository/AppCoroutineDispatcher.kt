package com.artsman.hasqvarnamovies.data.movieslist.repository

import kotlinx.coroutines.CoroutineDispatcher

class AppCoroutineDispatchers(
    val io: CoroutineDispatcher,
    val main: CoroutineDispatcher,
    val default: CoroutineDispatcher,
    val mainImmediate: CoroutineDispatcher
)
