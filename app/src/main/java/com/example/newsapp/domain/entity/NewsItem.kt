package com.example.newsapp.domain.entity

data class NewsItem(
    val content: String,
    val description: String,
    val publishedAt: String,
    val title: String,
    val url: String,
    val urlToImage: String
)
