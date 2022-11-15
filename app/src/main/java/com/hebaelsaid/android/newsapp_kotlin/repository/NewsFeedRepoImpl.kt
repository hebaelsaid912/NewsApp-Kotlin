package com.hebaelsaid.android.newsapp_kotlin.repository

import com.hebaelsaid.android.newsapp_kotlin.domain.data.remote.news.NewsApiService
import com.hebaelsaid.android.newsapp_kotlin.domain.model.response.news.NewsFeedsResponseModel
import javax.inject.Inject

class NewsFeedRepoImpl @Inject constructor(
    private val api: NewsApiService
) : NewsApiService {
    override suspend fun getNewsFeed(): NewsFeedsResponseModel {
        return api.getNewsFeed()
    }
}