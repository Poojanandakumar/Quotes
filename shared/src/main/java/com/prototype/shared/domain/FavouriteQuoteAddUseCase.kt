package com.prototype.shared.domain

import com.prototype.shared.room.FavouriteQuoteDao
import com.prototype.shared.room.FavouriteQuoteEntity
import javax.inject.Inject

class FavouriteQuoteAddUseCase @Inject constructor(private val favouriteQuoteDao: FavouriteQuoteDao) {

    suspend fun insert(entity: FavouriteQuoteEntity) {
        favouriteQuoteDao.addFavQuote(entity)
    }
}