package com.prototype.model.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class FavouriteQuoteEntity(
    @PrimaryKey @ColumnInfo(name = "quote") val quote: String,
    @ColumnInfo(name = "author") val author:String
)
