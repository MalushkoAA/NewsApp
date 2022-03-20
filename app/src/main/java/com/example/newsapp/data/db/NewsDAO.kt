package com.example.newsapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NewsDAO {
    @Query("SELECT * FROM news_list ORDER BY publishedAt DESC")
    fun getNewsList(): LiveData<List<NewsItemDbModel>>

    @Query("SELECT * FROM news_list WHERE url == :url LIMIT 1")
    fun getItem(url: String): LiveData<NewsItemDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNewsList(newsList: List<NewsItemDbModel>)
}