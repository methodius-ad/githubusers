package com.githubusers.di


import com.githubusers.presentation.screens.users.UsersViewModel
import com.githubusers.presentation.screens.users.UsersViewModelImpl
import com.githubusers.presentation.screens.info.UserDetailsScreenViewModel
import com.githubusers.presentation.screens.info.UserDetailsScreenViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.bind
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::UsersViewModelImpl) { bind<UsersViewModel>() }
    viewModelOf(::UserDetailsScreenViewModelImpl) { bind<UserDetailsScreenViewModel>() }
}