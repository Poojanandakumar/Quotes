package com.prototype.shared.data

import androidx.annotation.WorkerThread
import com.prototype.model.room.FavouriteQuoteDao
import javax.inject.Inject

class FavouriteQuoteAddUseCase @Inject constructor(private val favouriteQuoteDao: FavouriteQuoteDao) {

    suspend fun insert(quote:String,author:String) {
        favouriteQuoteDao.addFavQuote(quote,author)
    }
}