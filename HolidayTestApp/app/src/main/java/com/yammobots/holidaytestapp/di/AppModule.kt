package com.yammobots.holidaytestapp.di

import android.app.Application
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.yammobots.holidaytestapp.R
import com.yammobots.holidaytestapp.custom_control.MyanProgressDialog
import com.yammobots.holidaytestapp.util.AppConstants
import com.yammobots.holidaytestapp.util.SharePreferenceHelper
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by kaungkhantsoe on 13/06/2020.
 **/

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideSharePreferenceHelperInstance(application: Application): SharePreferenceHelper {
        return SharePreferenceHelper(application)
    }

    @Singleton
    @Provides
    fun provideRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideRequestOptions(): RequestOptions {
        return RequestOptions
            .placeholderOf(R.drawable.placeholder)
            .error(R.drawable.placeholder)
            .centerCrop()
    }

    @Singleton
    @Provides
    fun provideGlideInstance(
        application: Application,
        requestOptions: RequestOptions
    ): RequestManager {
        return Glide.with(application)
            .setDefaultRequestOptions(requestOptions)
    }

//    @Singleton
//    @Provides
//    static Drawable provideAppDrawable(Application application) {
//        return ContextCompat.getDrawable(application, R.drawable.logo_foreground);
//    }

    //    @Singleton
    //    @Provides
    //    static Drawable provideAppDrawable(Application application) {
    //        return ContextCompat.getDrawable(application, R.drawable.logo_foreground);
    //    }
    @Singleton
    @Provides
    fun provieMyanProgressDialog(application: Application): MyanProgressDialog {
        return MyanProgressDialog(application)
    }
}