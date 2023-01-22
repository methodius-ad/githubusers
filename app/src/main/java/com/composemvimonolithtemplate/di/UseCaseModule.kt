package com.composemvimonolithtemplate.di

import com.composemvimonolithtemplate.domain.use_case.get_home_data.GetHomeDataUseCase
import com.composemvimonolithtemplate.domain.use_case.get_home_data.GetHomeDataUseCaseImpl
import com.composemvimonolithtemplate.domain.use_case.get_info_data.GetInfoDataUseCase
import com.composemvimonolithtemplate.domain.use_case.get_info_data.GetInfoDataUseCaseImpl
import com.composemvimonolithtemplate.domain.use_case.get_profile_data.GetProfileDataUseCase
import com.composemvimonolithtemplate.domain.use_case.get_profile_data.GetProfileDataUseCaseImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val useCaseModule = module {
    factoryOf(::GetHomeDataUseCaseImpl) { bind<GetHomeDataUseCase>() }
    factoryOf(::GetInfoDataUseCaseImpl) { bind<GetInfoDataUseCase>() }
    factoryOf(::GetProfileDataUseCaseImpl) { bind<GetProfileDataUseCase>() }
}