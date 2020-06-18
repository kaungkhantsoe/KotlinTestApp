package com.yammobots.holidaytestapp.di.main.dining

import androidx.lifecycle.ViewModel
import com.yammobots.holidaytestapp.di.ViewModelKey
import com.yammobots.holidaytestapp.ui.main.dining.DiningViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by kaungkhantsoe on 17/06/2020.
 **/

@Module
abstract class DiningViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(DiningViewModel::class)
    abstract fun bindDiningViewModel(diningViewModel: DiningViewModel) : ViewModel
}