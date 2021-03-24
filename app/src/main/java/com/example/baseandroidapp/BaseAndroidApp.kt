package com.example.baseandroidapp

import android.app.Application
import com.example.factory.PresenterFactory

class BaseAndroidApp : Application() {

    companion object {
        lateinit var instance: BaseAndroidApp
    }

    val presenterFactory = PresenterFactory()

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}