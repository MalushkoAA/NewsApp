package com.example.newsapp.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class NewsItemDbModel constructor(
    @PrimaryKey
    val url: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val title: String,
    val urlToImage: String
)
