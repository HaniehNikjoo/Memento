package com.example.myapplication.di

import com.hafizco.cardservices.data.network.api.ApiInterface
import com.hafizco.cardservices.data.network.api.ApiService
import org.koin.dsl.module
import retrofit2.Retrofit

private val retrofit: Retrofit = createNetworkClient()

private val api: ApiService = ApiService(retrofit.create(ApiInterface::class.java))

private val serverCoordinator: ServerCoordinator = ServerCoordinator(api)


val networkModule = module {
    single {
        serverCoordinator
    }

}