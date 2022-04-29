package com.example.data.repository

import com.example.data.api.ApiPhoto
import com.example.data.dao.DataDao
import com.example.domain.models.PhotosResponseItem
import com.example.domain.repository.DataRepository
import retrofit2.Response

class DataRepositoryImpl(val apiUser: ApiPhoto, val dao: DataDao): DataRepository {

    override suspend fun getData(): Response<ArrayList<PhotosResponseItem>> {
        return apiUser.getData()
    }

    override suspend fun getDataDB(): ArrayList<PhotosResponseItem> {
        return dao.queryData() as ArrayList<PhotosResponseItem>
    }

    override suspend fun insertDB(photosResponseItem: PhotosResponseItem) {
        dao.insertData(photosResponseItem)
    }

}