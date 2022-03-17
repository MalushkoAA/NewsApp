package com.example.newsapp.domain.usecases

import com.example.newsapp.domain.repo.NewsRepo

class LoadDataUseCase(
    private val newsRepo: NewsRepo
) {
    fun loadData() = newsRepo.loadData()
}