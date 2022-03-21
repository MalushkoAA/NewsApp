package com.example.newsapp.ui.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.newsapp.databinding.FragmentNewsDetailBinding
import com.example.newsapp.ui.viewmodels.NewsViewModel

class NewsDetailFragment : Fragment() {

private lateinit var viewModel: NewsViewModel

    private var _binding: FragmentNewsDetailBinding? = null
    private val binding: FragmentNewsDetailBinding
        get() = _binding ?: throw RuntimeException("FragmentNewsDetailBinding == null")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewsDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val url = getUrl()
        viewModel=ViewModelProvider(this)[NewsViewModel::class.java]
        viewModel.getNewsDetail(url).observe(viewLifecycleOwner){
            with(binding){
                Glide.with(ivDetail.context)
                    .load(it.urlToImage)
                    .into(ivDetail)
                tvTitleDetail.text=it.title
                tvDescriptionDetail.text=it.description
            }
        }
    }

    private fun getUrl(): String {
        return requireArguments().getString(EXTRA_FROM_URL, EMPTY_SYMBOL)
    }


    companion object {

        private const val EXTRA_FROM_URL = "url"
        private const val EMPTY_SYMBOL = ""

        fun newInstance(url: String): NewsDetailFragment {
            return NewsDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(EXTRA_FROM_URL, url)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
