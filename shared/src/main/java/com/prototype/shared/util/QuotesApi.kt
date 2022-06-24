package com.prototype.shared.util

import com.prototype.model.QuotesData
import com.prototype.shared.util.Result
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface QuotesApi {

    @GET("/quotes")
    suspend fun getData(): QuotesData

}