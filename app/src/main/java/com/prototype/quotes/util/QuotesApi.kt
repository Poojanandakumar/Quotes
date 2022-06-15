package com.prototype.quotes.util

import com.prototype.model.QuotesData
import retrofit2.Response
import retrofit2.http.GET

interface QuotesApi {

    @GET("/quotes")
    suspend fun getData(): Response<QuotesData>

}