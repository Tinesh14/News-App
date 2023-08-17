package com.example.myapplication.network.api

import com.example.myapplication.data.model.NewsResponse
import retrofit2.Response
import javax.inject.Inject

 class ApiHelperImpl @Inject constructor(private val newsApi: NewsApi) : ApiHelper {

    override suspend fun getNews(countryCode: String, pageNumber: Int, category: String): Response<NewsResponse> =
        newsApi.getNews(countryCode, pageNumber, category = category)

    override suspend fun searchNews(query: String, pageNumber: Int): Response<NewsResponse> =
        newsApi.searchNews(query, pageNumber)

}