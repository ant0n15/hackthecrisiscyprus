package com.delivery.bakery.usecase

import androidx.lifecycle.MutableLiveData
import com.delivery.bakery.data.StoresItem
import kotlinx.coroutines.CoroutineScope
import retrofit2.Call
import retrofit2.Response

abstract class BaseUseCaseNoArg<RESULT> : BaseUseCase<RESULT, Unit>() {

    fun execute(scope: CoroutineScope) {
        execute(scope, Unit)
    }

    override suspend fun onExecute(scope: CoroutineScope, argument: Unit) {
        onExecute(scope)
    }

    protected abstract suspend fun onExecute(scope: CoroutineScope): MutableLiveData<ArrayList<StoresItem>>
}
