package com.example.testappforoptima.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.cases.GetDataUseCase

class MainViewModelFactory(val data: GetDataUseCase): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(data) as T

    }
}