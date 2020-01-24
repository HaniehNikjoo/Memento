package com.example.myapplication.ui.splash

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.example.myapplication.R
import com.example.myapplication.ui.base.BaseActivity

class SplashActivity : BaseActivity() {
    private val viewModel: SplashViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        viewModel.liveData.observe(this, Observer {
            when (it) {
                is SplashState.MainActivity -> {
                    it.goToActivity()
                }
                is SplashState.UserRegistrationActivity -> {
                    it.goToActivity()
                }

            }
        })
    }

    private fun SplashState.goToActivity() {
        if(this is SplashState.MainActivity) startActivity(
            Intent(this@SplashActivity, MainActivity::class.java)
        )
        else if(this is SplashState.UserRegistrationActivity) startActivity(
            Intent(this@SplashActivity, UserRegistrationActivity::class.java)
        )
        finish()
    }
}