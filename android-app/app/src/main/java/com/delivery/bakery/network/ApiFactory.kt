package com.delivery.bakery.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

class ApiFactory {

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val retrofit: Retrofit = Retrofit.Builder()
        .client(OkHttpClient().newBuilder().addInterceptor(loggingInterceptor).build())
        .baseUrl("https://aqueous-thicket-50958.herokuapp.com")
        .build()

    fun <T> createService(service: Class<T>): T {
        return retrofit.create(service)
    }
}