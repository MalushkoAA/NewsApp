package com.example.newsapp.domain.usecases

import android.content.Context
import com.example.newsapp.domain.repo.NewsRepo
import javax.inject.Inject

class OpenNewsInSourceUseCase @Inject constructor(
    private val newsRepo: NewsRepo
) {
    operator fun invoke(context: Context,url: String) = newsRepo.openNewsInSource(context, url)
}