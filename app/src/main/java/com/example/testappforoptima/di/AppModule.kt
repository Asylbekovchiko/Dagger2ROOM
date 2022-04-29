package com.example.testappforoptima.di

import android.content.Context
import androidx.room.Room
import com.example.domain.cases.GetDataUseCase
import com.example.testappforoptima.presentation.MainViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    fun provideMainVMFactory(dataUseCase: GetDataUseCase): MainViewModelFactory{
        return MainViewModelFactory(dataUseCase)
    }

}