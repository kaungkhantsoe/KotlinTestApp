package com.yammobots.holidaytestapp.di.main.users

import androidx.lifecycle.ViewModel
import com.yammobots.holidaytestapp.di.ViewModelKey
import com.yammobots.holidaytestapp.ui.main.users.UsersViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by kaungkhantsoe on 17/06/2020.
 **/

@Module
abstract class UsersViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(UsersViewModel::class)
    abstract fun bindUsersViewModel(usersViewModel: UsersViewModel) : ViewModel
}