package com.yammobots.holidaytestapp.di.main.home

import androidx.lifecycle.ViewModel
import com.yammobots.holidaytestapp.di.ViewModelKey
import com.yammobots.holidaytestapp.ui.main.home.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by kaungkhantsoe on 17/06/2020.
 **/

@Module
abstract class HomeViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(homeViewModel: HomeViewModel) : ViewModel
}