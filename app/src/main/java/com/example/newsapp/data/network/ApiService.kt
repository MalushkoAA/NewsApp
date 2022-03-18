package com.example.newsapp.data.network

import com.example.newsapp.data.network.models.NewsResponseModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


    @GET("top-headlines")
    suspend fun getNewsList(
        @Query(QUERY_PARAM_COUNTRY) country: String = COUNTRY,
        @Query(QUERY_PARAM_PAGE_SIZE) pageSize: String = PAGE_SIZE,
        @Query(QUERY_PARAM_API_KEY) apiKey: String = API_KEY
    ): NewsResponseModel

    companion object {
        private const val QUERY_PARAM_COUNTRY = "country"
        private const val QUERY_PARAM_PAGE_SIZE = "pageSize"
        private const val QUERY_PARAM_API_KEY = "apiKey"

        private const val COUNTRY = "ru"
        private const val PAGE_SIZE = "30"
        private const val API_KEY = "670be7b6b41d4840bad4dd482d833474"
    }

}