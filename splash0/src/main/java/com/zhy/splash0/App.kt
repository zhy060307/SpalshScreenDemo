package com.zhy.splash0

import android.app.Application

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Thread.sleep(2000)
    }
}