package com.example.newsapp.domain.repo

import androidx.lifecycle.LiveData
import com.example.newsapp.domain.entity.NewsItem

interface NewsRepo {

    fun getNewsItemsList(): LiveData<List<NewsItem>>

    fun getNewsItem( url:String): LiveData<NewsItem>

    fun loadData()
}