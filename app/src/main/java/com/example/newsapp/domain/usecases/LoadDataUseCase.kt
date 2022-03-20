package com.example.newsapp.domain.usecases

import com.example.newsapp.domain.repo.NewsRepo

class LoadDataUseCase(
    private val newsRepo: NewsRepo
) {
    suspend operator fun invoke() = newsRepo.loadData()
}