package com.example.myapplication.di

import android.util.Log
import com.example.myapplication.common.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

import java.util.concurrent.TimeUnit

private val baseUrl = Constants.BASE

private fun getLogInterceptor() = HttpLoggingInterceptor(
        HttpLoggingInterceptor.Logger {
            Log.e("MY_TAG",it)
        }).apply {
    level = HttpLoggingInterceptor.Level.BODY
}

fun createNetworkClient() = retrofitClient(baseUrl, okHttpClient().build())

private fun okHttpClient() = OkHttpClient.Builder()
        .addInterceptor(getLogInterceptor()).apply {
            readTimeout(Constants.NETWORK_TIMEOUT_SECONDS, TimeUnit.SECONDS)
            connectTimeout(Constants.NETWORK_TIMEOUT_SECONDS, TimeUnit.SECONDS)
            writeTimeout(Constants.NETWORK_TIMEOUT_SECONDS, TimeUnit.SECONDS)
            retryOnConnectionFailure(false)
        }

private fun retrofitClient(baseUrl: String, httpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(httpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()