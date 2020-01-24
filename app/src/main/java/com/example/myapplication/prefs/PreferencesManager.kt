package com.example.myapplication.prefs

interface PreferencesManager {
    fun isLogin(): Boolean
    fun setLogin(isLogging: Boolean)
    fun saveMobile(): String
    fun setMobile(mobile: String)
    fun getToken(): String
    fun saveToken(token: String)
}
