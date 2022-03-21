package com.example.newsapp.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.newsapp.databinding.NewsItemBinding
import com.example.newsapp.domain.entity.NewsItem

class NewsAdapter(
    private val context: Context?
) : ListAdapter<NewsItem, NewsViewHolder>(NewsDiffCallback) {

    var onNewsClickListener: OnNewsClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = NewsItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = getItem(position)
        with(holder.binding) {
            with(news) {
                Glide.with(ivOverview.context)
                    .load(urlToImage)
                    .into(ivOverview)
                tvTitleOverview.text = title
                root.setOnClickListener {
                    onNewsClickListener?.onNewsClick(this)
                }
            }
        }
    }

    interface OnNewsClickListener {
        fun onNewsClick(newsDetail: NewsItem)
    }

}