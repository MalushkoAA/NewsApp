package com.example.newsapp.ui.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.newsapp.databinding.FragmentNewsOverviewBinding
import com.example.newsapp.domain.entity.NewsItem
import com.example.newsapp.ui.adapters.NewsAdapter
import com.example.newsapp.ui.viewmodels.NewsOverviewViewModel
import kotlinx.coroutines.NonDisposableHandle.parent

class NewsOverviewFragment : Fragment() {

    private lateinit var viewModel: NewsOverviewViewModel

    private var _binding: FragmentNewsOverviewBinding?=null
    private val binding:FragmentNewsOverviewBinding
    get() = _binding?:throw RuntimeException("FragmentCoinDetailBinding is null")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding= FragmentNewsOverviewBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = NewsAdapter(context)
        adapter.onNewsClickListener=object :NewsAdapter.OnNewsClickListener{
            override fun onNewsClick(newsDetail: NewsItem) {
                TODO("Not yet implemented")
            }
        }
        binding.rvNewsList.adapter=adapter
        viewModel=ViewModelProvider(this)[NewsOverviewViewModel::class.java]
        viewModel.newsItemsList.observe(viewLifecycleOwner){
            adapter.submitList(it)
        }

    }
}