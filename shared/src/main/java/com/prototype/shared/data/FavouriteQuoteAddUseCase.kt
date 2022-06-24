package com.prototype.shared.data

import androidx.annotation.WorkerThread
import com.prototype.model.room.FavouriteQuoteDao
import com.prototype.model.room.FavouriteQuoteEntity
import javax.inject.Inject

class FavouriteQuoteAddUseCase @Inject constructor(private val favouriteQuoteDao: FavouriteQuoteDao) {

    suspend fun insert(entity: FavouriteQuoteEntity) {
        favouriteQuoteDao.addFavQuote(entity)
    }
}