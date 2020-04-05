package com.delivery.bakery.injection.module

import android.app.Application
import com.delivery.bakery.injection.App
import com.delivery.bakery.injection.scopes.PerApplication
import com.delivery.bakery.network.BakeryApi
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class AppModule {

    @Provides
    @PerApplication
    fun provideApplication(application: App): Application = application

    @Provides
    @PerApplication
    fun provideIoCoroutineDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        return Retrofit.Builder()
            .client(OkHttpClient().newBuilder().addInterceptor(loggingInterceptor).build())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://aqueous-thicket-50958.herokuapp.com")
            .build()
    }

    @Provides
    fun provideBakeryApi(retrofit: Retrofit): BakeryApi {
        return retrofit.create(BakeryApi::class.java)
    }

    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }


}