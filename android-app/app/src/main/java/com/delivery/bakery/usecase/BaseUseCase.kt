package com.delivery.bakery.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

abstract class BaseUseCase<RESULT, ARGUMENT> {

    private val state: MutableLiveData<RESULT> = MutableLiveData()
    val result: LiveData<RESULT> = state

    private val handler = CoroutineExceptionHandler { _, throwable -> onError(throwable) }

    fun execute(scope: CoroutineScope, argument: ARGUMENT) {
        scope.launch(handler) {
            onExecute(this, argument)
        }
    }

    protected abstract suspend fun onExecute(scope: CoroutineScope, argument: ARGUMENT)

    protected open fun onError(throwable: Throwable) {
        throwable.printStackTrace()
    }

    protected fun setResult(result: RESULT) {
        state.value = result
    }
}