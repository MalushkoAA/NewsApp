package com.example.newsapp.ui.screens

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.newsapp.R
import com.example.newsapp.databinding.FragmentNewsOverviewBinding
import com.example.newsapp.domain.entity.NewsItem
import com.example.newsapp.ui.App
import com.example.newsapp.ui.adapters.NewsAdapter
import com.example.newsapp.ui.viewmodels.NewsViewModel
import com.example.newsapp.ui.viewmodels.ViewModelFactory
import javax.inject.Inject


class NewsOverviewFragment : Fragment() {

    private lateinit var viewModel: NewsViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private var _binding: FragmentNewsOverviewBinding? = null
    private val binding: FragmentNewsOverviewBinding
        get() = _binding ?: throw RuntimeException("FragmentCoinDetailBinding is null")

    override fun onAttach(context: Context) {
        (requireActivity().application as App).appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewsOverviewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = NewsAdapter(context)
        adapter.onNewsClickListener = object : NewsAdapter.OnNewsClickListener {
            override fun onNewsClick(newsDetail: NewsItem) {
                launchDetailFragment(newsDetail.url)
            }
        }
        binding.rvNewsList.adapter = adapter
        viewModel = ViewModelProvider(this, viewModelFactory)[NewsViewModel::class.java]
        viewModel.newsItemsList.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    private fun launchDetailFragment(url: String) {
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_container, NewsDetailFragment.newInstance(url))
            .addToBackStack(null)
            .commit()
    }

}