package com.hebaelsaid.android.newsapp_kotlin.domain.data.remote.news


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val NEWS_BASE_URL = "https://www.reddit.com/r/kotlin/"
private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(NEWS_BASE_URL)
    .build()
object NewsApiClient {
    val retrofitService:NewsApiService by lazy { retrofit.create(NewsApiService::class.java) }
}