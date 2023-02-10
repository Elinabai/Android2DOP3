package com.geektech.android2dop3

import android.app.Application
import com.geektech.android2dop3.utils.PreferenceHelper

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        initPref()
    }

    private fun initPref() {
        val preferenceHelper = PreferenceHelper()
        preferenceHelper.unit(this)
    }
}