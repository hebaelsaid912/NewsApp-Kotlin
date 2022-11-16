package com.hebaelsaid.android.newsapp_kotlin.domain.uimodel

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NewsFeedUiModel(
    val thumbnail_url:String?=null,
    val thumbnail_height:Int?=null,
    val thumbnail_width:Int?=null,
    val title:String,
    val description:String?=null
) : Parcelable
