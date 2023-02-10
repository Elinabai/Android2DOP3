package com.geektech.android2dop3.utils

import android.content.Context
import android.content.SharedPreferences

class PreferenceHelper {

    private lateinit var sharedPreference: SharedPreferences

    fun unit(context: Context){
        sharedPreference = context.getSharedPreferences("settings",Context.MODE_PRIVATE)
    }

    var safeText: String?
        set(value) = sharedPreference.edit().putString("key",value).apply()
        get() = sharedPreference.getString("key","")

    var safePass: String?
        set(value) = sharedPreference.edit().putString("key2",value).apply()
        get() = sharedPreference.getString("key2","")
}