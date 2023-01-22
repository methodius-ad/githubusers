package com.composemvimonolithtemplate.di

import com.composemvimonolithtemplate.presentation.screens.home.HomeViewModel
import com.composemvimonolithtemplate.presentation.screens.home.HomeViewModelImpl
import com.composemvimonolithtemplate.presentation.screens.info.InfoScreenViewModel
import com.composemvimonolithtemplate.presentation.screens.info.InfoScreenViewModelImpl
import com.composemvimonolithtemplate.presentation.screens.profile.ProfileViewModel
import com.composemvimonolithtemplate.presentation.screens.profile.ProfileViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.bind
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::HomeViewModelImpl) { bind<HomeViewModel>() }
    viewModelOf(::ProfileViewModelImpl) { bind<ProfileViewModel>() }
    viewModelOf(::InfoScreenViewModelImpl) { bind<InfoScreenViewModel>() }
}