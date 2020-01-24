package com.example.myapplication.di

import com.example.myapplication.prefs.AppPreferencesManager
import org.koin.dsl.module

private val preferencesManager: AppPreferencesManager = AppPreferencesManager()

val prefsModule = module {

    single {
        preferencesManager
    }
}