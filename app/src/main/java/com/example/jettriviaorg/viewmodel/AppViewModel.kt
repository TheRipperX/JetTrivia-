package com.example.jettriviaorg.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jettriviaorg.model.ResponseJson
import com.example.jettriviaorg.repository.AppRepository
import com.example.jettriviaorg.utils.DataOrException
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(private val rep: AppRepository) : ViewModel() {

    val dataViewModel = mutableStateOf(DataOrException(ArrayList<ResponseJson.ResponseJsonItem>(), true, Exception("")))

    init {
        getAllViewModel()
    }

    private fun getAllViewModel() = viewModelScope.launch {

        try {
            dataViewModel.value.loading = true
            dataViewModel.value = rep.getAllData()
            //Log.d("TAG FATHI", "getAllViewModel: $dataViewModel")
            if (dataViewModel.value.data!!.isNotEmpty()) dataViewModel.value.loading = false


        }catch (e: Exception) {
            dataViewModel.value.e = e
            dataViewModel.value.loading = false
        }

    }
}