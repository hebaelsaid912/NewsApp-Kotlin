package com.hebaelsaid.android.newsapp_kotlin.ui.feature.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hebaelsaid.android.newsapp_kotlin.domain.model.response.news.NewsFeedsResponseModel
import com.hebaelsaid.android.newsapp_kotlin.domain.model.ui.NewsFeedUiModel
import com.hebaelsaid.android.newsapp_kotlin.repository.NewsFeedRepoImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

private const val TAG = "HomeViewModel"
class HomeViewModel : ViewModel() {
    private val newsFeedApiState = MutableStateFlow<NewsFeedState>(NewsFeedState.Idle)
    val _newsFeedApiState: StateFlow<NewsFeedState> get() = newsFeedApiState

    sealed class NewsFeedState {
        data class Success(val newsFeedList: ArrayList<NewsFeedUiModel>) : NewsFeedState()
        data class Error(val message: String) : NewsFeedState()
        object Loading : NewsFeedState()
        object Idle : NewsFeedState()
    }

    suspend fun getNewsFeedData() = viewModelScope.launch(Dispatchers.IO) {
        newsFeedApiState.value = NewsFeedState.Loading
        val newsFeedList = NewsFeedRepoImpl.getNewsFeed()
       val newsFeedUiList =  getUIModel(newsFeedList)
        delay(1000)
        newsFeedApiState.value = NewsFeedState.Success(newsFeedUiList)
    }

    private fun getUIModel(newsFeedList: NewsFeedsResponseModel):ArrayList<NewsFeedUiModel> {
        Log.d(TAG, "getUIModel: newsFeedList size: ${newsFeedList.data!!.children!!.size}")
        val newsFeedUiList = ArrayList<NewsFeedUiModel>()
            for (data in newsFeedList.data!!.children!!) {
                newsFeedUiList.add(NewsFeedUiModel(
                    thumbnail_url = data!!.data!!.media?.oembed?.thumbnail_url,
                    thumbnail_height = data.data!!.media?.oembed?.thumbnail_height,
                    thumbnail_width = data.data.media?.oembed?.thumbnail_width,
                    title = data.data.title!!
                ))
        }
        return newsFeedUiList
    }
}