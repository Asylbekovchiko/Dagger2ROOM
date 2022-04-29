package com.example.testappforoptima.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.cases.GetDataUseCase
import com.example.domain.models.PhotosResponseItem
import kotlinx.coroutines.launch

class MainViewModel(
    private val data: GetDataUseCase,

    ) : ViewModel() {

    val _mld = MutableLiveData<ArrayList<PhotosResponseItem>>()
    val _ld: LiveData<ArrayList<PhotosResponseItem>> = _mld

    val _mldDB = MutableLiveData<ArrayList<PhotosResponseItem>>()
    val _ldDB: LiveData<ArrayList<PhotosResponseItem>> = _mldDB

    suspend fun getData() {

        viewModelScope.launch {
            val response = data.getData()

            if (response!!.isSuccessful) {
                _mld.postValue(response.body())
            } else {
                Log.e("Error", "Error")
            }
        }
    }

    suspend fun getDataDB(): ArrayList<PhotosResponseItem> {
            return data.getDataDB()
    }

    suspend fun insertDB(photosResponseItem: PhotosResponseItem){
        data.insertDB(photosResponseItem)
    }

}