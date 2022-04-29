package com.example.testappforoptima.di

import com.example.data.api.ApiPhoto
import com.example.data.dao.DataDao
import com.example.data.repository.DataRepositoryImpl
import com.example.domain.repository.DataRepository
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

    const val baseUrl = "https://picsum.photos/v2/"

@Module(includes = [NetworkModule::class])
class DataModule {

    @Provides
    fun provideDataRepo(apiUser: ApiPhoto, dao: DataDao): DataRepository {
        return DataRepositoryImpl(apiUser, dao)
    }
}

@Module
class NetworkModule{

    @Provides
    @Singleton
    fun getRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(getOkHttp())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun getHttpLogInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @Provides
    fun getOkHttp(): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(getHttpLogInterceptor()).build()
    }

    @Provides
    @Singleton
    internal fun getApiUser(retrofit: Retrofit): ApiPhoto {
        return retrofit.create(ApiPhoto::class.java)
    }
}
