package com.example.presenters.common

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect

abstract class BasePresenter {

    private var job: Job? = null

    fun onViewStart() {
        CoroutineScope(Dispatchers.Main).launch {
            listenToViewModelAndUpdateUi()
            onStart()
        }.also {
            this.job = it
        }
    }

    protected abstract suspend fun onStart()

    protected abstract suspend fun listenToViewModelAndUpdateUi()

    protected suspend fun <T>listenTo(flow: Flow<T>, onEach: (T)->Unit ) {
        CoroutineScope(currentCoroutineContext()).launch {
            flow.collect {
                onEach.invoke(it)
            }
        }
    }

    fun onViewStop() {
        job?.cancel()
    }

    fun onViewDestroyed() {
        job?.cancel()
    }
}
