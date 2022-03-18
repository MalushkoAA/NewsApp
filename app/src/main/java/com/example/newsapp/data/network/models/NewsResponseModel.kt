package com.example.newsapp.data.network.models

data class NewsResponseModel(
    val articles: List<NewsItemDto>,
    val status: String,
    val totalResults: Int
)
