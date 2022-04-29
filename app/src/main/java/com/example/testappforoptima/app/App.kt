package com.example.testappforoptima.app

import android.app.Activity
import android.app.Application
import androidx.fragment.app.Fragment
import com.example.testappforoptima.di.AppComponent
import com.example.testappforoptima.di.AppModule
import com.example.testappforoptima.di.DaggerAppComponent
import com.example.testappforoptima.di.RoomDatabaseModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject


class App : Application(), HasSupportFragmentInjector, HasActivityInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

//    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.builder()            .setLocalModule(RoomDatabaseModule(this))

            .application(this).build().inject(this)
    }
    override fun activityInjector(): AndroidInjector<Activity> = activityInjector

    override fun supportFragmentInjector(): AndroidInjector<Fragment>  = fragmentInjector

}