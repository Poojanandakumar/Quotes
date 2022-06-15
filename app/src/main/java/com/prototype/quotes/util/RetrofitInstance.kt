package com.prototype.quotes.util

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val api: QuotesApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.quotable.io")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(QuotesApi::class.java)
    }
}