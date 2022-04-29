package com.example.testappforoptima.di

import com.example.domain.cases.GetDataUseCase
import com.example.domain.repository.DataRepository
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideGetDataUseCase(repo: DataRepository): GetDataUseCase {
        return GetDataUseCase(repo)
    }
}