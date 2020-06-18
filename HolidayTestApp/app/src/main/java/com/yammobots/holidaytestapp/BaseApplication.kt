package com.yammobots.holidaytestapp

import com.yammobots.holidaytestapp.custom_control.AndroidCommonSetup
import com.yammobots.holidaytestapp.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

/**
 * Created by kaungkhantsoe on 13/06/2020.
 **/
class BaseApplication : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()

        AndroidCommonSetup.getInstance().init(applicationContext)
    }

    private val applicationInjector = DaggerAppComponent.builder()
        .application(this)
        .build()

    override fun applicationInjector() = applicationInjector
}