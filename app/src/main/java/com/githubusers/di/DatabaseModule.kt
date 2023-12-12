package com.githubusers.di

import android.content.Context
import androidx.room.Room
import com.githubusers.data.db.AppDatabase
import org.koin.dsl.module


val databaseModule = module {
    single {
        provideAppDatabase(get())
    }
}

fun provideAppDatabase(context: Context): AppDatabase {
    return Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        DATABASE_NAME
    ).build()
}

const val DATABASE_NAME = "APP_DB"