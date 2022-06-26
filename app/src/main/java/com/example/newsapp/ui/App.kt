package com.example.newsapp.ui

import android.app.Application
import com.example.newsapp.di.AppComponent
import com.example.newsapp.di.DaggerAppComponent

class App:Application() {
    val appComponent:AppComponent by lazy {
        DaggerAppComponent.factory().create(this)
    }
}