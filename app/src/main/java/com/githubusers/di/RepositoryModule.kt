package com.githubusers.di

import com.githubusers.data.repository.UsersRepositoryImpl
import com.githubusers.domain.repository.UsersRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val repositoryModule = module {
    singleOf(::UsersRepositoryImpl) { bind<UsersRepository>() }
}