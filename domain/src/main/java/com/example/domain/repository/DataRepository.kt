package com.example.domain.repository

import com.example.domain.models.PhotosResponseItem
import retrofit2.Response

interface DataRepository {
    suspend fun getData(): Response<ArrayList<PhotosResponseItem>>

    suspend fun getDataDB(): ArrayList<PhotosResponseItem>

    suspend fun insertDB(photosResponseItem: PhotosResponseItem)
}
