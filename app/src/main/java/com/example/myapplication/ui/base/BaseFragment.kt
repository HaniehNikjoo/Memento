package com.example.myapplication.ui.base

import android.app.ProgressDialog
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {
    private var progressDialog: ProgressDialog? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super<Fragment>.onDestroyView()
    }

    fun showToast(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
    }

    fun showToast(@StringRes string: Int) {
        Toast.makeText(activity, getString(string), Toast.LENGTH_SHORT).show()
    }
    protected fun initProgressDialog() {
        progressDialog = ProgressDialog(activity)
        progressDialog!!.setMessage("درحال بارگذاری...")
        progressDialog!!.show()
    }

    protected fun hideProgressDialog() {
        progressDialog?.dismiss()
    }
}