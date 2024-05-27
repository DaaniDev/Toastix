package org.daanidev.toastix

import android.app.Application

class MyApplication : Application() {

    companion object{
        var instance: MyApplication? = null
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}