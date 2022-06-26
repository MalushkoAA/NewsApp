package com.example.newsapp.di

import android.app.Application
import com.example.newsapp.ui.screens.NewsDetailFragment
import com.example.newsapp.ui.screens.NewsOverviewFragment
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
    modules = [
        DataModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application
        ): AppComponent
    }

    fun inject(fragment: NewsOverviewFragment)
    fun inject(fragment: NewsDetailFragment)


}