package com.prototype.shared.data

import com.prototype.model.QuotesData
import com.prototype.shared.util.QuotesApi
import com.prototype.shared.util.Result
import retrofit2.Response
import javax.inject.Inject

interface QuotesDataSource {
    suspend fun getUserData(): QuotesData
}

class RestApiQuotesDataSource @Inject constructor(private val api:QuotesApi):QuotesDataSource{
    override suspend fun getUserData(): QuotesData {
        return api.getData()
    }
}