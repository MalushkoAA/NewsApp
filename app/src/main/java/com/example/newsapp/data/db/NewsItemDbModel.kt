package com.example.newsapp.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "news_list")
data class NewsItemDbModel(
    val description: String?,
    val publishedAt: String,
    @PrimaryKey
    val title: String,
    val url: String,
    val urlToImage: String?
)
