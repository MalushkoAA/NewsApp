package com.example.newsapp.domain.usecases

import androidx.lifecycle.LiveData
import com.example.newsapp.domain.entity.NewsItem
import com.example.newsapp.domain.repo.NewsRepo

class GetNewsItemsListUseCase(
    private val newsRepo: NewsRepo
) {
    fun getNewsItemsList(): LiveData<List<NewsItem>> {
        return newsRepo.getNewsItemsList()
    }
}