package com.example.newsapp.di

import android.app.Application
import com.example.newsapp.data.db.NewsDAO
import com.example.newsapp.data.db.NewsDatabase
import com.example.newsapp.data.network.ApiFactory
import com.example.newsapp.data.network.ApiService
import com.example.newsapp.data.repo.NewsRepoImpl
import com.example.newsapp.domain.repo.NewsRepo
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @Binds
    @ApplicationScope
    fun bindNewsRepo(impl: NewsRepoImpl):NewsRepo

    companion object{

        @Provides
        @ApplicationScope
        fun provideNesDao(application: Application):NewsDAO{
            return NewsDatabase.getDatabase(application).newsDao()
        }

        @Provides
        @ApplicationScope
        fun provideApiService(): ApiService{
            return ApiFactory.apiService
        }
    }

}