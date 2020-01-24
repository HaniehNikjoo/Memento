package com.example.myapplication.prefs

import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.example.myapplication.App

class AppPreferencesManager : PreferencesManager {
    private var mPrefs: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(App.instance)

    override fun isLogin(): Boolean {
        return mPrefs.getBoolean(PREF_KEY_IS_LOGIN, false)
    }
    override fun setLogin(isLogging: Boolean){
        mPrefs.edit().putBoolean(PREF_KEY_IS_LOGIN, isLogging).apply()
    }
    override fun saveMobile(): String {
        return mPrefs.getString(PREF_KEY_MOBILE, "")!!
    }
    override fun setMobile(mobile: String) {
        mPrefs.edit().putString(PREF_KEY_MOBILE, mobile).apply()
    }
    override fun getToken(): String {
        return mPrefs.getString(PREF_KEY_TOKEN, "")!!
    }
    override fun saveToken(token: String) {
        mPrefs.edit().putString(PREF_KEY_TOKEN, token).apply()
    }
    companion object {
        private const val PREF_KEY_IS_LOGIN = "PREF_KEY_IS_LOGIN"
        private const val PREF_KEY_MOBILE = "PREF_KEY_MOBILE"
        private const val PREF_KEY_TOKEN = "PREF_KEY_TOKEN"
    }
}
