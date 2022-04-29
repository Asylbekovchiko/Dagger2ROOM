package com.example.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.domain.models.PhotosResponseItem

@Dao
interface DataDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insertData(data: PhotosResponseItem)

    @Query("SELECT * from data")
     fun queryData(): List<PhotosResponseItem>
}