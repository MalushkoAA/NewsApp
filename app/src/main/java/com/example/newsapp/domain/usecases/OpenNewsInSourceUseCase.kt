package com.example.newsapp.domain.usecases

import android.content.Context
import com.example.newsapp.domain.repo.NewsRepo

class OpenNewsInSourceUseCase (
    private val newsRepo: NewsRepo
) {
    operator fun invoke(context: Context,url: String) = newsRepo.openNewsInSource(context, url)
}