package com.shashlik.app.apps

import android.app.Application
import com.shashlik.app.dbhelper.MyDatabase

class Apps : Application() {
    override fun onCreate() {
        super.onCreate()
        MyDatabase.init(this)
    }
}