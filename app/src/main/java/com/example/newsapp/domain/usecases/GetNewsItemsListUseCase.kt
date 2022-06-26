package com.example.newsapp.domain.usecases

import androidx.lifecycle.LiveData
import com.example.newsapp.domain.entity.NewsItem
import com.example.newsapp.domain.repo.NewsRepo
import javax.inject.Inject

class GetNewsItemsListUseCase @Inject constructor(
    private val newsRepo: NewsRepo
) {
    operator fun invoke() = newsRepo.getNewsItemsList()
}