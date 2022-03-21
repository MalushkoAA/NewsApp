package com.example.newsapp.ui.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.newsapp.domain.entity.NewsItem

object NewsDiffCallback : DiffUtil.ItemCallback<NewsItem>() {
    override fun areItemsTheSame(oldItem: NewsItem, newItem: NewsItem): Boolean {
        return oldItem.url == newItem.url
    }

    override fun areContentsTheSame(oldItem: NewsItem, newItem: NewsItem): Boolean {
        return oldItem == newItem
    }
}