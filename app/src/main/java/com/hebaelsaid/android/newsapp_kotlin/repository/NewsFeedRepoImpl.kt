package com.hebaelsaid.android.newsapp_kotlin.repository

import com.hebaelsaid.android.newsapp_kotlin.domain.data.remote.news.NewsApiClient
import com.hebaelsaid.android.newsapp_kotlin.domain.data.remote.news.NewsApiService
import com.hebaelsaid.android.newsapp_kotlin.domain.model.response.news.NewsFeedsResponseModel

object NewsFeedRepoImpl : NewsApiService {
    override suspend fun getNewsFeed(): NewsFeedsResponseModel {
        return NewsApiClient.retrofitService.getNewsFeed()
    }
}