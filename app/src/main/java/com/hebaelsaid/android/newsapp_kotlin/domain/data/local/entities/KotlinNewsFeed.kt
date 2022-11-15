package com.hebaelsaid.android.newsapp_kotlin.domain.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "kotlin_news")
data class KotlinNewsFeed(
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    @ColumnInfo(name = "news_title")
    val news_title: String,
    @ColumnInfo(name = "news_thumbnail_url")
    val news_thumbnail_url: String,
    @ColumnInfo(name = "news_thumbnail_height")
    val news_thumbnail_height:Int,
    @ColumnInfo(name = "news_thumbnail_width")
    val news_thumbnail_width:Int,
    @ColumnInfo(name = "news_self_text")
    val news_self_text:String

)
