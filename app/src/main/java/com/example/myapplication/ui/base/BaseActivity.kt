package com.example.myapplication.ui.base

import android.app.ProgressDialog
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {
    private var progressDialog: ProgressDialog? = null

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    fun showToast(@StringRes string: Int) {
        Toast.makeText(this, getString(string), Toast.LENGTH_SHORT).show()
    }

    protected fun initProgressDialog() {
        progressDialog = ProgressDialog(this)
        progressDialog!!.setMessage("درحال بارگذاری...")
        progressDialog!!.show()
    }

    protected fun hideProgressDialog() {
        progressDialog?.dismiss()
    }
}