package com.hebaelsaid.android.newsapp_kotlin.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hebaelsaid.android.newsapp_kotlin.data.local.entities.KotlinNewsFeed


@Dao
interface NewsDao {
    @get:Query("SELECT * FROM kotlin_news ORDER BY id DESC")
    val getAllKotlinNews:List<KotlinNewsFeed>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertKotlinNews(category: KotlinNewsFeed)
    @Query("DELETE  FROM kotlin_news")
    suspend fun clearKotlinNewsDatabase()
}