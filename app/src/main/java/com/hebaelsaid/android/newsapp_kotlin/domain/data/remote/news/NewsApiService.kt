package com.hebaelsaid.android.newsapp_kotlin.domain.data.remote.news

import com.hebaelsaid.android.newsapp_kotlin.domain.model.response.news.NewsFeedsResponseModel
import retrofit2.http.GET

interface NewsApiService {

    @GET(".json")
    suspend fun getNewsFeed():NewsFeedsResponseModel
}