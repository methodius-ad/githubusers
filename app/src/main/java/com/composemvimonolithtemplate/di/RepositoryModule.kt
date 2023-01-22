package com.composemvimonolithtemplate.di

import com.composemvimonolithtemplate.data.repository.MockRepositoryImpl
import com.composemvimonolithtemplate.domain.repository.MockRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val repositoryModule = module {
    singleOf(::MockRepositoryImpl) { bind<MockRepository>() }
}