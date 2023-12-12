package com.githubusers.di

import com.githubusers.data.MoshiArrayListJsonAdapter
import com.githubusers.data.api.ApiService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val networkModule: Module = module {
    single {
        Moshi.Builder()
            .add(MoshiArrayListJsonAdapter.FACTORY)
            .add(KotlinJsonAdapterFactory())
            .build()
    }
    single {
        // TODO: move base url from here to not hardcode
        val baseUrl = "https://api.github.com/"
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(MoshiConverterFactory.create(get()).withNullSerialization().asLenient())
            .build()
    }

    single { get<Retrofit>().create(ApiService::class.java) }
}