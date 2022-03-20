package com.example.newsapp.data.repo

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.newsapp.data.db.NewsDatabase
import com.example.newsapp.data.mapper.NewsMapper
import com.example.newsapp.data.network.ApiFactory
import com.example.newsapp.domain.entity.NewsItem
import com.example.newsapp.domain.repo.NewsRepo

class NewsRepoImpl(
    private val application: Application
) : NewsRepo {

    private val newsDao = NewsDatabase.getDatabase(application).newsDao()
    private val apiService = ApiFactory.apiService
    private val mapper = NewsMapper()


    override fun getNewsItemsList(): LiveData<List<NewsItem>> {
        return Transformations.map(newsDao.getNewsList()) {
            it.map {
                mapper.mapDbModelToEntity(it)
            }
        }
    }

    override fun getNewsItem(url: String): LiveData<NewsItem> {
        return Transformations.map(newsDao.getItem(url)) {
            mapper.mapDbModelToEntity(it)
        }
    }

    override suspend fun loadData() {
        try {
            val newsList=apiService.getNewsList().articles
            val dbModelList=newsList.map{mapper.mapDtoToDbModel(it)}
            newsDao.insertNewsList(dbModelList)
        } catch (e: Exception) {
        }
    }
}