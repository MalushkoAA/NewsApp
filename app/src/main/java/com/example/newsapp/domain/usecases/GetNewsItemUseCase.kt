package com.example.newsapp.domain.usecases

import androidx.lifecycle.LiveData
import com.example.newsapp.domain.entity.NewsItem
import com.example.newsapp.domain.repo.NewsRepo
import javax.inject.Inject

class GetNewsItemUseCase @Inject constructor(
    private val newsRepo: NewsRepo
) {
    operator fun invoke(url: String) = newsRepo.getNewsItem(url)

}