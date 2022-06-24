package com.prototype.shared.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.prototype.shared.room.FavouriteQuoteDao
import com.prototype.shared.room.FavouriteQuoteEntity

@Database(entities = [FavouriteQuoteEntity::class], version = 1, exportSchema = false)
abstract class FavouriteQuoteRoomDatabase : RoomDatabase() {

    abstract fun favouriteQuoteDao(): FavouriteQuoteDao
}