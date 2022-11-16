package com.hebaelsaid.android.newsapp_kotlin.data.remote.client

import com.hebaelsaid.android.newsapp_kotlin.data.remote.responsemodel.NewsFeedsResponseModel
import retrofit2.http.GET

interface NewsApiService {

    @GET(".json")
    suspend fun getNewsFeed(): NewsFeedsResponseModel
}