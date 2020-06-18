package com.yammobots.holidaytestapp.di;

import androidx.lifecycle.ViewModelProvider;

import com.yammobots.holidaytestapp.viewmodels.ViewModelProviderFactory;

import dagger.Binds;
import dagger.Module;

/**
 * Created by kaungkhantsoe on 2020-02-02.
 **/

@Module
public abstract class ViewModelFactoryModule {

    @Binds
    public abstract ViewModelProvider.Factory bindViewModelProviderFactory(ViewModelProviderFactory viewModelProviderFactory);

   /*

   // Works the same as " bindViewModelProviderFactory "
    @Provides
    static ViewModelProvider.Factory bindFactory(ViewModelProviderFactory viewModelProviderFactory) {
        return viewModelProviderFactory;
    }

    */



}
