package com.example.testappforoptima.di

import com.example.testappforoptima.presentation.photo.HomeFragment
import com.example.testappforoptima.presentation.photo.randomphoto.RandomFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {
    @ContributesAndroidInjector
     abstract fun contributeHomeFragment(): HomeFragment

    @ContributesAndroidInjector
     abstract fun contributeRandomFragment(): RandomFragment
}