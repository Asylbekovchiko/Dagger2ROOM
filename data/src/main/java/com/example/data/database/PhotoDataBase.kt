package com.example.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.data.dao.DataDao
import com.example.domain.models.PhotosResponseItem


@Database(entities = [PhotosResponseItem::class], version = 1)
abstract class PhotoDatabase : RoomDatabase() {

    abstract fun getDataDAO(): DataDao
}