package com.hebaelsaid.android.newsapp_kotlin.domain.repository

import com.hebaelsaid.android.newsapp_kotlin.data.remote.client.NewsApiService
import com.hebaelsaid.android.newsapp_kotlin.data.remote.responsemodel.NewsFeedsResponseModel
import javax.inject.Inject

class NewsFeedRepoImpl @Inject constructor(
    private val api: NewsApiService
) : NewsApiService {
    override suspend fun getNewsFeed(): NewsFeedsResponseModel {
        return api.getNewsFeed()
    }
}