package com.prototype.shared.data

import com.prototype.model.QuotesData
import retrofit2.Response
import javax.inject.Inject

interface QuotesRepository {
    suspend fun getUserData(): QuotesData
}

class DefaultQuotesRepository @Inject constructor(private val dataSource: QuotesDataSource):QuotesRepository{
    override suspend fun getUserData(): QuotesData {
        return dataSource.getUserData()
    }
}