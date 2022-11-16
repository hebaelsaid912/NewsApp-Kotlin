package com.hebaelsaid.android.newsapp_kotlin.ui.feature.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hebaelsaid.android.newsapp_kotlin.data.local.database.NewsDatabase
import com.hebaelsaid.android.newsapp_kotlin.data.local.entities.KotlinNewsFeed
import com.hebaelsaid.android.newsapp_kotlin.domain.uimodel.NewsFeedUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "HomeViewModel"
@HiltViewModel
class HomeViewModel @Inject constructor(private val newsDatabase: NewsDatabase) : ViewModel() {
    private val newsFeedDBState = MutableStateFlow<NewsFeedState>(NewsFeedState.Idle)
    val _newsFeedDBState: StateFlow<NewsFeedState> get() = newsFeedDBState

    sealed class NewsFeedState {
        data class Success(val newsFeedList: ArrayList<NewsFeedUiModel>) : NewsFeedState()
        data class Error(val message: String) : NewsFeedState()
        object Loading : NewsFeedState()
        object Idle : NewsFeedState()
    }

    suspend fun getNewsFeedData() = viewModelScope.launch(Dispatchers.IO) {
        newsFeedDBState.value = NewsFeedState.Loading
        val newsFeedList = newsDatabase.newsDao().getAllKotlinNews
       val newsFeedUiList =  getUIModel(newsFeedList)
        delay(1000)
        newsFeedDBState.value = try {
            NewsFeedState.Success(newsFeedUiList)
        } catch ( ex: Exception){
            NewsFeedState.Error(ex.message!!)
        }
    }

    private fun getUIModel(newsFeedList: List<KotlinNewsFeed>):ArrayList<NewsFeedUiModel> {
        Log.d(TAG, "getUIModel: newsFeedList size: ${newsFeedList.size}")
        val newsFeedUiList = ArrayList<NewsFeedUiModel>()
            for (data in newsFeedList) {
                newsFeedUiList.add(
                    NewsFeedUiModel(
                    thumbnail_url = data.news_thumbnail_url,
                    thumbnail_height = data.news_thumbnail_height,
                    thumbnail_width = data.news_thumbnail_width,
                    title = data.news_title,
                    description = data.news_self_text)
                )
        }
        return newsFeedUiList
    }
}