package com.example.newsapp.domain.usecases

import com.example.newsapp.domain.repo.NewsRepo
import javax.inject.Inject

class LoadDataUseCase @Inject constructor(
    private val newsRepo: NewsRepo
) {
    suspend operator fun invoke() = newsRepo.loadData()
}