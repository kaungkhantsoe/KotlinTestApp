package com.yammobots.holidaytestapp.di

import android.app.Application
import com.yammobots.holidaytestapp.BaseApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by kaungkhantsoe on 13/06/2020.
 **/
@Singleton
@Component(modules = [AndroidSupportInjectionModule::class,
    ActivityBuildersModule::class,
    AppModule::class,
    ViewModelFactoryModule::class])
interface AppComponent : AndroidInjector<BaseApplication?> {

//    override fun inject(instance: BaseApplication?) {
//    }

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}
