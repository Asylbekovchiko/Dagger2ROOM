package com.example.testappforoptima.di

import android.app.Application
import com.example.testappforoptima.app.App
import com.example.testappforoptima.presentation.MainActivity
import com.example.testappforoptima.presentation.photo.HomeFragment
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class,AppModule::class, DataModule::class, DomainModule::class, FragmentModule::class,MainActivityModule::class, RoomDatabaseModule::class])

interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun setLocalModule(roomDatabaseModule: RoomDatabaseModule): Builder
        fun build(): AppComponent
    }
    fun inject(app: App)
}