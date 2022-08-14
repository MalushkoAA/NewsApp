package com.example.newsapp.ui

import android.app.Application
import com.example.newsapp.di.DaggerAppComponent

class App:Application() {
    val appComponent by lazy {
        DaggerAppComponent.factory().create(this)
    }
}