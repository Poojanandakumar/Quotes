package com.prototype.model.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface FavouriteQuoteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addFavQuote(quote: String, author: String)
}