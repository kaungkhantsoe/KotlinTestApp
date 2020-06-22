package com.yammobots.holidaytestapp.di

import androidx.lifecycle.ViewModelProvider
import com.yammobots.holidaytestapp.viewmodels.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

/**
 * Created by kaungkhantsoe on 22/06/2020.
 **/

@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelProviderFactory(viewModelProviderFactory: ViewModelProviderFactory?): ViewModelProvider.Factory? /*

   // Works the same as " bindViewModelProviderFactory "
    @Provides
    static ViewModelProvider.Factory bindFactory(ViewModelProviderFactory viewModelProviderFactory) {
        return viewModelProviderFactory;
    }

    */
}
