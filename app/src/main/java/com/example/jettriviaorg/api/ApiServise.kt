package com.example.jettriviaorg.api

import com.example.jettriviaorg.model.ResponseJson
import retrofit2.Response
import retrofit2.http.GET


interface ApiServise {

    @GET("world.json")
    suspend fun getAllJson(): Response<ResponseJson>
}