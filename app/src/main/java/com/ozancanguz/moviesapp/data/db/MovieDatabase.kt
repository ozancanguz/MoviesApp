package com.ozancanguz.moviesapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(entities = [FavoritesEntity::class], version = 1,
    exportSchema = false,)

@TypeConverters(TypeConverter::class)
abstract class MovieDatabase {
    abstract fun favoritesDao():FavoritesDao
}