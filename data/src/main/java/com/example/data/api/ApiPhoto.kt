package com.example.data.api

import com.example.domain.models.PhotosResponseItem
import retrofit2.Response
import retrofit2.http.GET

interface ApiPhoto {

    @GET("list")
    suspend fun getData(): Response<ArrayList<PhotosResponseItem>>
}