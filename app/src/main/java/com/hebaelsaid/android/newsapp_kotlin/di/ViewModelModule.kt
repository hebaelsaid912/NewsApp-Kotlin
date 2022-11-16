package com.hebaelsaid.android.newsapp_kotlin.di

import android.content.Context
import com.hebaelsaid.android.newsapp_kotlin.data.local.database.NewsDatabase
import com.hebaelsaid.android.newsapp_kotlin.data.remote.client.NewsApiService
import com.hebaelsaid.android.newsapp_kotlin.domain.repository.NewsFeedRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class ViewModelModule {

    @ViewModelScoped
    @Provides
    fun getDatabase(@ApplicationContext context: Context): NewsDatabase {
        return NewsDatabase.getDatabase(context)
    }

    @ViewModelScoped
    @Provides
    fun getNewsRepoImpl(api: NewsApiService): NewsFeedRepoImpl {
        return NewsFeedRepoImpl(api = api)
    }



}