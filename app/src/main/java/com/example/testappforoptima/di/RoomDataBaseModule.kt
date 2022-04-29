package com.example.testappforoptima.di

import android.app.Application
import androidx.room.Room
import com.example.data.database.PhotoDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomDatabaseModule(application: Application) {

    private var libraryApplication = application
    private lateinit var phoDatabase: PhotoDatabase


    @Singleton
    @Provides
    fun providesRoomDatabase(): PhotoDatabase {
        phoDatabase = Room.databaseBuilder(libraryApplication, PhotoDatabase::class.java, "library_database")
            .fallbackToDestructiveMigration()
            .build()
        return phoDatabase
    }

    @Singleton
    @Provides
    fun providesDataDAO(photoDatabase: PhotoDatabase) = photoDatabase.getDataDAO()
}