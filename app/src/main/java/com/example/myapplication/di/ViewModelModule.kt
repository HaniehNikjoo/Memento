package com.example.myapplication.di

import com.example.myapplication.ui.dashboard.DashboardViewModel
import com.example.myapplication.ui.home.HomeViewModel
import com.example.myapplication.ui.settings.SettingsViewModel
import com.example.myapplication.ui.splash.SplashViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
        viewModel { DashboardViewModel() }
        viewModel { HomeViewModel() }
        viewModel { SettingsViewModel() }
        viewModel { SplashViewModel() }
}
