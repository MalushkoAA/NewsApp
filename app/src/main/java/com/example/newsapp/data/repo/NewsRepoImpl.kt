package com.example.newsapp.data.repo

import android.app.Application
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.newsapp.data.db.NewsDAO
import com.example.newsapp.data.db.NewsDatabase
import com.example.newsapp.data.mapper.NewsMapper
import com.example.newsapp.data.network.ApiFactory
import com.example.newsapp.data.network.ApiService
import com.example.newsapp.domain.entity.NewsItem
import com.example.newsapp.domain.repo.NewsRepo
import javax.inject.Inject


class NewsRepoImpl @Inject constructor(
    private val newsDao:NewsDAO,
    private val apiService:ApiService,
    private val mapper:NewsMapper,
    private val application: Application
) : NewsRepo {

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

    override fun openNewsInSource(context: Context, url: String) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(context, browserIntent, null)
    }
}