package com.example.domain.cases

import com.example.domain.models.PhotosResponseItem
import com.example.domain.repository.DataRepository
import retrofit2.Response

class GetDataUseCase(val repository: DataRepository) {

    suspend fun getData(): Response<ArrayList<PhotosResponseItem>> {
        return repository.getData()
    }

    suspend fun getDataDB(): ArrayList<PhotosResponseItem> {
        return repository.getDataDB()
    }

    suspend fun insertDB(photosResponseItem: PhotosResponseItem){
        repository.insertDB(photosResponseItem)
    }
}

