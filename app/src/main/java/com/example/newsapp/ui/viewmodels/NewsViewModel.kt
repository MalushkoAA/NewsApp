package com.example.newsapp.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.data.repo.NewsRepoImpl
import com.example.newsapp.domain.usecases.GetNewsItemUseCase
import com.example.newsapp.domain.usecases.GetNewsItemsListUseCase
import com.example.newsapp.domain.usecases.LoadDataUseCase
import kotlinx.coroutines.launch

class NewsViewModel(application: Application) : AndroidViewModel(application) {
    private val repo = NewsRepoImpl(application)
    private val getNewsItemsListUseCase = GetNewsItemsListUseCase(repo)
    private val loadDataUseCase = LoadDataUseCase(repo)
    private val getNewsItemUseCase = GetNewsItemUseCase(repo)

    fun getNewsDetail(url:String)= getNewsItemUseCase(url)

    val newsItemsList= getNewsItemsListUseCase()

    init {
        viewModelScope.launch {
            loadDataUseCase()
        }
    }



}