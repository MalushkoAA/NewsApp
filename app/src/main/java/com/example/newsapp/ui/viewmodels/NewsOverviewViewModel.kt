package com.example.newsapp.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.data.repo.NewsRepoImpl
import com.example.newsapp.domain.usecases.GetNewsItemUseCase
import com.example.newsapp.domain.usecases.GetNewsItemsListUseCase
import com.example.newsapp.domain.usecases.LoadDataUseCase
import kotlinx.coroutines.launch

class NewsOverviewViewModel(application: Application) : AndroidViewModel(application) {
    private val repo = NewsRepoImpl(application)
    private val getNewsItemsListUseCase = GetNewsItemsListUseCase(repo)
    private val getNewsItemUseCase = GetNewsItemUseCase(repo)
    private val loadDataUseCase = LoadDataUseCase(repo)

    val newsItemsList= getNewsItemsListUseCase()

    fun getNewsDetail(url:String)=getNewsItemUseCase(url)

    init {
        viewModelScope.launch {
            loadDataUseCase()
        }
    }



}