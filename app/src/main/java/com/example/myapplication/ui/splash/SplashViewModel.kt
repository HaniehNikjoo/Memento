package com.example.myapplication.ui.splash

import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.prefs.AppPreferencesManager

class SplashViewModel: ViewModel() {
    private val preferencesManager: AppPreferencesManager = AppPreferencesManager()
    private val SPLASH_TIME_OUT:Long=1000 // 3 sec

    val liveData: LiveData<SplashState> get() = mutableLiveData
    private val mutableLiveData = MutableLiveData<SplashState>()

    init {
        Handler().postDelayed({
            if(preferencesManager.isLogin())
                mutableLiveData.postValue(SplashState.MainActivity)
            else
                mutableLiveData.postValue(SplashState.UserRegistrationActivity)
        }, SPLASH_TIME_OUT)
    }
}

sealed class SplashState {
    object MainActivity : SplashState()
    object UserRegistrationActivity : SplashState()
}

