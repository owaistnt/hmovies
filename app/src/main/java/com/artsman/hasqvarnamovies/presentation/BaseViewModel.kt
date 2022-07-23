package com.artsman.hasqvarnamovies.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow

abstract class BaseViewModel<A, S, E>: ViewModel(), IViewModel<A, S, E> {
    abstract var initalState: S
    protected val stateHolder : MutableStateFlow<S> = MutableStateFlow(initalState)
    protected val eventHolder : MutableSharedFlow<E?> = MutableSharedFlow()

    override suspend fun onEventConsumed(){
        eventHolder.emit(null)
    }

    fun sendState(state: S){
        stateHolder.value = state
    }

    suspend fun fireEvent(event : E){
        eventHolder.emit(event)
    }
}