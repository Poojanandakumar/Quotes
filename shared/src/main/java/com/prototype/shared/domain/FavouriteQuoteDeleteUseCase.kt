package com.prototype.shared.domain

import com.prototype.shared.room.FavouriteQuoteDao
import com.prototype.shared.room.FavouriteQuoteEntity
import javax.inject.Inject

class FavouriteQuoteDeleteUseCase@Inject constructor(private val favouriteQuoteDao: FavouriteQuoteDao) {
    suspend fun delete(entity: FavouriteQuoteEntity) {
        favouriteQuoteDao.deleteFavQuote(entity)
    }
}