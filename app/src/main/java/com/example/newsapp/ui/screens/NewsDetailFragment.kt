package com.example.newsapp.ui.screens

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.newsapp.R
import com.example.newsapp.databinding.FragmentNewsDetailBinding
import com.example.newsapp.ui.App
import com.example.newsapp.ui.viewmodels.NewsViewModel
import com.example.newsapp.ui.viewmodels.ViewModelFactory
import javax.inject.Inject

class NewsDetailFragment : Fragment() {

    private lateinit var viewModel: NewsViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private var _binding: FragmentNewsDetailBinding? = null
    private val binding: FragmentNewsDetailBinding
        get() = _binding ?: throw RuntimeException("FragmentNewsDetailBinding == null")

    override fun onAttach(context: Context) {
        (requireActivity().application as App).appComponent.inject(this)
        super.onAttach(context)
    }

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
        viewModel = ViewModelProvider(this, viewModelFactory)[NewsViewModel::class.java]
        viewModel.getNewsDetail(url).observe(viewLifecycleOwner) {
            with(binding) {
                Glide.with(ivDetail.context)
                    .load(it.urlToImage)
                    .apply(
                        RequestOptions()
                            .placeholder(R.drawable.loading_animation)
                            .error(R.drawable.ic_broken_image)
                    )
                    .into(ivDetail)
                tvTitleDetail.text = it.title
                tvDescriptionDetail.text = it.description
                btnOpenInSource.setOnClickListener { viewModel.openNews(requireContext(), url) }
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
