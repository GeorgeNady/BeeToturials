package com.george.beetoturials.base

import android.app.Application


class BaseApplication : Application() {

    companion object {
        lateinit var baseApplication: BaseApplication
    }

    override fun onCreate() {
        super.onCreate()
        baseApplication = this
    }

}