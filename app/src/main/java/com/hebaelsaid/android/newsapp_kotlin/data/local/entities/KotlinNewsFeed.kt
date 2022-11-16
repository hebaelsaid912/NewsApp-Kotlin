package com.hebaelsaid.android.newsapp_kotlin.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "kotlin_news")
data class KotlinNewsFeed(
    @PrimaryKey(autoGenerate = true)
    var id:Int?=null,
    @ColumnInfo(name = "news_title")
    val news_title: String,
    @ColumnInfo(name = "news_thumbnail_url")
    val news_thumbnail_url: String?=null,
    @ColumnInfo(name = "news_thumbnail_height")
    val news_thumbnail_height:Int?=null,
    @ColumnInfo(name = "news_thumbnail_width")
    val news_thumbnail_width:Int?=null,
    @ColumnInfo(name = "news_self_text")
    val news_self_text:String

)
