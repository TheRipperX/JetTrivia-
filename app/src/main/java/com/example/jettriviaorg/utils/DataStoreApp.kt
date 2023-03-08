package com.example.jettriviaorg.utils

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DataStoreApp @Inject constructor(@ApplicationContext private val context: Context) {


    companion object {
        private val Context.dataStoreApp: DataStore<Preferences> by preferencesDataStore(dataStoreApp)
        private val counterInt = intPreferencesKey(dataQuestion)
    }

    suspend fun saveCounter(num: Int){
        context.dataStoreApp.edit {
            it[counterInt] = num
        }
    }

    fun showCounter() = context.dataStoreApp.data.map {
        it[counterInt] ?: 0
    }
}