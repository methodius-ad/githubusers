package com.githubusers.di

import com.githubusers.domain.use_case.change_saved_status.ChangeSavedStatusUseCase
import com.githubusers.domain.use_case.change_saved_status.ChangeSavedStatusUseCaseImpl
import com.githubusers.domain.use_case.fetch_users.FetchUsersUseCase
import com.githubusers.domain.use_case.fetch_users.FetchUsersUseCaseImpl
import com.githubusers.domain.use_case.fetch_user_details.FetchUserDetailsUseCase
import com.githubusers.domain.use_case.fetch_user_details.FetchUserDetailsUseCaseImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val useCaseModule = module {
    factoryOf(::FetchUsersUseCaseImpl) { bind<FetchUsersUseCase>() }
    factoryOf(::FetchUserDetailsUseCaseImpl) { bind<FetchUserDetailsUseCase>() }
    factoryOf(::ChangeSavedStatusUseCaseImpl) { bind<ChangeSavedStatusUseCase>() }
}