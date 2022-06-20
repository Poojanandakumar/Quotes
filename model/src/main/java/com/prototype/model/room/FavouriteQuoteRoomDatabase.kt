package com.prototype.model.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [FavouriteQuoteEntity::class], version = 1, exportSchema = false)
abstract class FavouriteQuoteRoomDatabase : RoomDatabase() {

    abstract fun favouriteQuoteDao(): FavouriteQuoteDao

//    companion object {
//        // Singleton prevents multiple instances of database opening at the
//        // same time.
//        @Volatile
//        private var INSTANCE: FavouriteQuoteRoomDatabase? = null
//
//        fun getDatabase(context: Context): FavouriteQuoteRoomDatabase {
//            return Room.databaseBuilder(
//                context,
//                FavouriteQuoteRoomDatabase::class.java,
//                "favouriteQuote_database"
//            )
//                .fallbackToDestructiveMigration()
//                .build()
//        }
//    }
}