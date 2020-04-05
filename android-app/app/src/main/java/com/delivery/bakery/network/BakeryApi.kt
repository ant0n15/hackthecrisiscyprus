package com.delivery.bakery.network

import androidx.lifecycle.MutableLiveData
import com.delivery.bakery.data.StoresItem
import retrofit2.http.GET
import retrofit2.http.Headers

interface BakeryApi {

    @Headers("Content-Type: application/x-www-form-urlencoded")
    @GET("/api/v1/stores")
    suspend fun stores(): MutableLiveData<ArrayList<StoresItem>>

    //@GET("categories/{store_id}")
    //fun categories(@Path("store_id") id: Int): Deferred<Response<Category>>

    //@GET("products/{category_id}")
    //fun products(@Path("category_id") id: Int): Deferred<Response<Product>>
}