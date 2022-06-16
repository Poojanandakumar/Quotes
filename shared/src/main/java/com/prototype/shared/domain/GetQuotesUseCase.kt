package com.prototype.shared.domain

import com.prototype.model.QuotesData
import com.prototype.shared.data.QuotesRepository
import com.prototype.shared.util.Result
import java.io.IOException
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(private val quotesRepository: QuotesRepository) {
    suspend fun getQuotesData(): Result<QuotesData> {
        try {
            return Result.Success(quotesRepository.getUserData())
        } catch (e: IOException) {
            return Result.Error(e)
        }

    }
}