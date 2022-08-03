package com.prototype.shared.room

import androidx.room.*

@Dao
interface FavouriteQuoteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addFavQuote(entity: FavouriteQuoteEntity)

    @Delete
    suspend fun deleteFavQuote(entity: FavouriteQuoteEntity)

    @Query("SELECT * FROM FavouriteQuoteEntity")
    suspend fun getFavouriteQuote(): List<FavouriteQuoteEntity>
}