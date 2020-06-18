package com.yammobots.holidaytestapp.di.main.home

import com.yammobots.holidaytestapp.network.HomeApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * Created by kaungkhantsoe on 18/06/2020.
 **/

@Module
class HomeModule {

    @HomeFragScope
    @Provides
    fun provideHomeApi(retrofit: Retrofit) : HomeApi {
        return retrofit.create(HomeApi::class.java)
    }
}