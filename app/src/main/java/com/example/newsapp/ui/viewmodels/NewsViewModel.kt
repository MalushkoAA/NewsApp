package com.example.newsapp.ui.viewmodels

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.data.repo.NewsRepoImpl
import com.example.newsapp.domain.usecases.GetNewsItemUseCase
import com.example.newsapp.domain.usecases.GetNewsItemsListUseCase
import com.example.newsapp.domain.usecases.LoadDataUseCase
import com.example.newsapp.domain.usecases.OpenNewsInSourceUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewsViewModel @Inject constructor(
    private val getNewsItemsListUseCase:GetNewsItemsListUseCase,
    private val loadDataUseCase:LoadDataUseCase,
    private val getNewsItemUseCase:GetNewsItemUseCase,
    private val openNewsInSourceUseCase:OpenNewsInSourceUseCase
) : ViewModel() {

    fun openNews(context: Context, url: String) = openNewsInSourceUseCase(context, url)

    fun getNewsDetail(url: String) = getNewsItemUseCase(url)

    val newsItemsList = getNewsItemsListUseCase()

    init {
        viewModelScope.launch {
            loadDataUseCase()
        }
    }


}