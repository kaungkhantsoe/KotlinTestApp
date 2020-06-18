package com.yammobots.holidaytestapp.di.main

import androidx.lifecycle.ViewModel
import com.yammobots.holidaytestapp.di.ViewModelKey
import com.yammobots.holidaytestapp.ui.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by kaungkhantsoe on 13/06/2020.
 **/

@Module
abstract class MainViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(mainViewModel: MainViewModel?): ViewModel?
}