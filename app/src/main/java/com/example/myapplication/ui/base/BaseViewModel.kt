package com.example.myapplication.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

open class BaseViewModel : ViewModel() {
    private val response = MutableLiveData<String>()
    private val error = MutableLiveData<String>()

    val disposable by lazy { CompositeDisposable() }

    override fun onCleared() {
        disposable.dispose()
        disposable.clear()
        super.onCleared()
    }

    fun getResponse(): MutableLiveData<String> {
        return response
    }

    fun getError(): MutableLiveData<String> {
        return error
    }

}