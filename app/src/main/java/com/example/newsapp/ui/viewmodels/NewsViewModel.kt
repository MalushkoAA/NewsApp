package com.example.newsapp.ui.viewmodels

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.data.repo.NewsRepoImpl
import com.example.newsapp.domain.usecases.GetNewsItemUseCase
import com.example.newsapp.domain.usecases.GetNewsItemsListUseCase
import com.example.newsapp.domain.usecases.LoadDataUseCase
import com.example.newsapp.domain.usecases.OpenNewsInSourceUseCase
import kotlinx.coroutines.launch

class NewsViewModel(application: Application) : AndroidViewModel(application) {
    private val repo = NewsRepoImpl(application)
    private val getNewsItemsListUseCase = GetNewsItemsListUseCase(repo)
    private val loadDataUseCase = LoadDataUseCase(repo)
    private val getNewsItemUseCase = GetNewsItemUseCase(repo)
    private val openNewsInSourceUseCase= OpenNewsInSourceUseCase(repo)

    fun openNews(context: Context, url: String)= openNewsInSourceUseCase(context, url)

    fun getNewsDetail(url:String)= getNewsItemUseCase(url)

    val newsItemsList= getNewsItemsListUseCase()

    init {
        viewModelScope.launch {
            loadDataUseCase()
        }
    }



}