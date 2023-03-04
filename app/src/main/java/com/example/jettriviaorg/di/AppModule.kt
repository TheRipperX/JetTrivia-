package com.example.jettriviaorg.di

import com.example.jettriviaorg.api.ApiServise
import com.example.jettriviaorg.repository.AppRepository
import com.example.jettriviaorg.utils.BASE_URL
import com.example.jettriviaorg.utils.TIME_OUT
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun proRepository(apiServise: ApiServise) = AppRepository(apiServise)

    @Provides
    @Singleton
    fun baseUrl() = BASE_URL

    @Provides
    @Singleton
    fun timeOut() = TIME_OUT

    @Provides
    @Singleton
    fun proGson(): Gson = GsonBuilder().setLenient().create()

    @Provides
    @Singleton
    fun proClient(time: Long) = OkHttpClient.Builder()
        .writeTimeout(time, TimeUnit.SECONDS)
        .readTimeout(time, TimeUnit.SECONDS)
        .connectTimeout(time, TimeUnit.SECONDS)
        .retryOnConnectionFailure(true)
        .build()

    @Provides
    @Singleton
    fun proRetrofit(baseurl: String, gson: Gson, client: OkHttpClient): ApiServise {
        return Retrofit.Builder()
            .baseUrl(baseurl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
            .create(ApiServise::class.java)

    }
}