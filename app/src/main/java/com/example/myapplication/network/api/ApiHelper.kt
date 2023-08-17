package com.example.myapplication.network.api


import com.example.myapplication.data.model.NewsResponse
import retrofit2.Response

interface ApiHelper {
    suspend fun searchNews(query: String, pageNumber: Int): Response<NewsResponse>
    suspend fun getNews(countryCode: String, pageNumber: Int, category: String): Response<NewsResponse>
}