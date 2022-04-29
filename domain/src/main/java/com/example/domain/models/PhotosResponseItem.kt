package com.example.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "data")
data class PhotosResponseItem(
    val id: String,
    val author: String,
    val download_url: String,
    @PrimaryKey(autoGenerate = true)
    val height: Int,
    val url: String,
    val width: Int
)