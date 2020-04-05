package com.delivery.bakery.usecase

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.delivery.bakery.data.StoresItem
import com.delivery.bakery.network.BakeryApi
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.withContext
import javax.inject.Inject

class BakeryUseCase @Inject constructor(
    private val dispatcher: CoroutineDispatcher
) : BaseUseCaseNoArg<BakeryUseCase.Result>() {

    @Inject
    lateinit var bakeryApi: BakeryApi

    sealed class Result {
        object None : Result()
        object Started : Result()
        object Finished : Result()
        object Error : Result()
    }

    public override suspend fun onExecute(scope: CoroutineScope): MutableLiveData<ArrayList<StoresItem>> {
        return withContext(dispatcher) {
            val stores = bakeryApi.stores()
            try {
                Log.d("Stores", stores.toString())
                //setResult(Result.Finished)
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return@withContext stores
        }
    }

    override fun onError(throwable: Throwable) {
        super.onError(throwable)
        setResult(Result.Error)
    }
}