package com.artsman.hasqvarnamovies.presentation

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharedFlow

interface IViewModel<A, S, E>{
    fun add(action : A)
    fun onStateChanged(): Flow<S>
    fun onEvents(): Flow<E?>
    suspend fun onEventConsumed()
}