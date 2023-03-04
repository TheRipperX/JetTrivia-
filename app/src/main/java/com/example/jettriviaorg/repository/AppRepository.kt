package com.example.jettriviaorg.repository

import com.example.jettriviaorg.api.ApiServise
import com.example.jettriviaorg.model.ResponseJson
import com.example.jettriviaorg.utils.DataOrException
import javax.inject.Inject

class AppRepository @Inject constructor(private val api: ApiServise) {

    private val dataAll = DataOrException<ArrayList<ResponseJson.ResponseJsonItem>,Boolean, Exception>()

    suspend fun getAllData(): DataOrException<ArrayList<ResponseJson.ResponseJsonItem>, Boolean, Exception> {
        try {
            dataAll.loading = true
            dataAll.data = api.getAllJson().body()

            if (dataAll.data!!.isNotEmpty()) dataAll.loading = false

        }catch (e: Exception) {
            dataAll.e = e
        }

        return dataAll
    }

}