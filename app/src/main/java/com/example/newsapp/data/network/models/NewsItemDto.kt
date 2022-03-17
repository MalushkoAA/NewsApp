package com.example.newsapp.data.network.models

data class NewsItemDto(
    val content: String,
    val description: String,
    val publishedAt: String,
    val title: String,
    val url: String,
    val urlToImage: String
)
