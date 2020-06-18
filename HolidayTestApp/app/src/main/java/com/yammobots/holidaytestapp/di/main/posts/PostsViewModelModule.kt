package com.yammobots.holidaytestapp.di.main.posts

import androidx.lifecycle.ViewModel
import com.yammobots.holidaytestapp.di.ViewModelKey
import com.yammobots.holidaytestapp.ui.main.posts.PostsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by kaungkhantsoe on 17/06/2020.
 **/

@Module
abstract class PostsViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(PostsViewModel::class)
    abstract fun bindPostViewModel(postsViewModel: PostsViewModel): ViewModel
}