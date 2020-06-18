package com.yammobots.holidaytestapp.di

import com.yammobots.holidaytestapp.di.main.MainFragmentBuildersModule
import com.yammobots.holidaytestapp.di.main.MainModule
import com.yammobots.holidaytestapp.di.main.MainScope
import com.yammobots.holidaytestapp.di.main.MainViewModelModule
import com.yammobots.holidaytestapp.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by kaungkhantsoe on 13/06/2020.
 **/

@Module
abstract class ActivityBuildersModule {

    @MainScope
    @ContributesAndroidInjector(modules = [
        MainViewModelModule::class,
        MainModule::class,
        MainFragmentBuildersModule::class
    ])
    abstract fun contributeMainActivity(): MainActivity?
}