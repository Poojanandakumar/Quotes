package com.prototype.shared.domain

import com.prototype.shared.room.FavouriteQuoteDao
import com.prototype.shared.room.FavouriteQuoteEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFavouriteQuotesUseCase @Inject constructor(private val favouriteQuoteDao: FavouriteQuoteDao) {
  suspend fun getFavQuotes():List<FavouriteQuoteEntity>{
        return favouriteQuoteDao.getFavouriteQuote()
    }
}