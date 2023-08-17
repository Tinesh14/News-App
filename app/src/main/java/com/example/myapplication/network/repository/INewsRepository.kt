package com.example.myapplication.network.repository


import androidx.lifecycle.LiveData
import com.example.myapplication.data.model.NewsArticle
import com.example.myapplication.data.model.NewsResponse
import com.example.myapplication.state.NetworkState

interface INewsRepository {
    suspend fun getNews(countryCode: String, pageNumber: Int, category: String): NetworkState<NewsResponse>

    suspend fun searchNews(searchQuery: String, pageNumber: Int): NetworkState<NewsResponse>

    suspend fun saveNews(news: NewsArticle): Long

    fun getSavedNews(): LiveData<List<NewsArticle>>

    suspend fun deleteNews(news: NewsArticle)

    suspend fun deleteAllNews()
}
