package com.composemvimonolithtemplate.di

import com.composemvimonolithtemplate.domain.use_case.get_user_info.GetUserInfoUseCase
import com.composemvimonolithtemplate.domain.use_case.get_user_info.GetUserInfoUseCaseImpl
import com.composemvimonolithtemplate.domain.use_case.update_user_info.UpdateUserInfoUseCase
import com.composemvimonolithtemplate.domain.use_case.update_user_info.UpdateUserInfoUseCaseImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val useCaseModule = module {
    factoryOf(::GetUserInfoUseCaseImpl) { bind<GetUserInfoUseCase>() }
    factoryOf(::UpdateUserInfoUseCaseImpl) { bind<UpdateUserInfoUseCase>() }
}