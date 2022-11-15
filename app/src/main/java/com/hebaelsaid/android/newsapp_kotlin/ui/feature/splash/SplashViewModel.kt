package com.hebaelsaid.android.newsapp_kotlin.ui.feature.splash

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hebaelsaid.android.newsapp_kotlin.domain.data.local.entities.KotlinNewsFeed
import com.hebaelsaid.android.newsapp_kotlin.domain.model.response.news.NewsFeedsResponseModel
import com.hebaelsaid.android.newsapp_kotlin.repository.NewsFeedRepoImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "SplashViewModel"
@HiltViewModel
class SplashViewModel @Inject constructor(private val newsFeedRepoImpl: NewsFeedRepoImpl) : ViewModel() {
    private val newsFeedApiState = MutableStateFlow<NewsFeedState>(NewsFeedState.Idle)
    val _newsFeedApiState: StateFlow<NewsFeedState> get() = newsFeedApiState

    sealed class NewsFeedState {
        data class Success(val newsFeedList: ArrayList<KotlinNewsFeed>) : NewsFeedState()
        data class Error(val message: String) : NewsFeedState()
        object Loading : NewsFeedState()
        object Idle : NewsFeedState()
    }

    suspend fun getNewsFeedData() = viewModelScope.launch(Dispatchers.IO) {
        newsFeedApiState.value = NewsFeedState.Loading
        val newsFeedList = newsFeedRepoImpl.getNewsFeed()
        val newsFeedUiList = getKotlinNewsDataFromApi(newsFeedList)
        delay(1000)
        newsFeedApiState.value = try {
            NewsFeedState.Success(newsFeedUiList)
        } catch (ex: Exception) {
            NewsFeedState.Error(ex.message!!)
        }
    }

    private fun getKotlinNewsDataFromApi(newsFeedList: NewsFeedsResponseModel): ArrayList<KotlinNewsFeed> {
        Log.d(TAG, "getUIModel: newsFeedList size: ${newsFeedList.data!!.children!!.size}")
        val newsFeedUiList = ArrayList<KotlinNewsFeed>()
        for (data in newsFeedList.data!!.children!!) {
            newsFeedUiList.add(
                KotlinNewsFeed(
                    news_thumbnail_url = data!!.data!!.media?.oembed?.thumbnail_url,
                    news_thumbnail_height = data.data!!.media?.oembed?.thumbnail_height,
                    news_thumbnail_width = data.data.media?.oembed?.thumbnail_width,
                    news_title = data.data.title!!,
                    news_self_text = data.data.selftext!!
                )
            )
        }
        return newsFeedUiList
    }
}