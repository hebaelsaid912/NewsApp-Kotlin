package com.hebaelsaid.android.newsapp_kotlin.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hebaelsaid.android.newsapp_kotlin.data.local.dao.NewsDao
import com.hebaelsaid.android.newsapp_kotlin.data.local.entities.KotlinNewsFeed

@Database(entities = [KotlinNewsFeed::class],
    version = 1 , exportSchema = false)
abstract class NewsDatabase : RoomDatabase() {
    companion object{
        var newsDatabase: NewsDatabase? = null

        @Synchronized
        fun getDatabase(context: Context) : NewsDatabase {
            if( newsDatabase == null){
                newsDatabase = Room.databaseBuilder(
                    context,
                    NewsDatabase::class.java,
                    "news.db"
                ).build()
            }
            return newsDatabase!!
        }

    }
    abstract fun newsDao(): NewsDao
}