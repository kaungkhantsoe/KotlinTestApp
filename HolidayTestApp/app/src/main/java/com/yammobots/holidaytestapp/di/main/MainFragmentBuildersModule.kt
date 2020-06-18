package com.yammobots.holidaytestapp.di.main

import com.yammobots.holidaytestapp.di.main.dining.DiningFragScope
import com.yammobots.holidaytestapp.di.main.dining.DiningViewModelModule
import com.yammobots.holidaytestapp.di.main.home.HomeFragScope
import com.yammobots.holidaytestapp.di.main.home.HomeModule
import com.yammobots.holidaytestapp.di.main.home.HomeViewModelModule
import com.yammobots.holidaytestapp.di.main.posts.PostsFragScope
import com.yammobots.holidaytestapp.di.main.posts.PostsViewModelModule
import com.yammobots.holidaytestapp.di.main.users.UsersFragScope
import com.yammobots.holidaytestapp.di.main.users.UsersViewModelModule
import com.yammobots.holidaytestapp.ui.main.dining.DiningFragment
import com.yammobots.holidaytestapp.ui.main.home.HomeFragment
import com.yammobots.holidaytestapp.ui.main.posts.PostsFragment
import com.yammobots.holidaytestapp.ui.main.users.UsersFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by kaungkhantsoe on 13/06/2020.
 **/

@Module
abstract class MainFragmentBuildersModule {

    @DiningFragScope
    @ContributesAndroidInjector(
        modules = [DiningViewModelModule::class]
    )
    abstract fun contributeDiningFragment(): DiningFragment

    @HomeFragScope
    @ContributesAndroidInjector(
        modules = [HomeViewModelModule::class, HomeModule::class]
    )
    abstract fun contributeHomeFragment(): HomeFragment

    @PostsFragScope
    @ContributesAndroidInjector(
        modules = [PostsViewModelModule::class]
    )
    abstract fun contributePostsFragment(): PostsFragment

    @UsersFragScope
    @ContributesAndroidInjector(
        modules = [UsersViewModelModule::class]
    )
    abstract fun contributeUsersFragment(): UsersFragment

}