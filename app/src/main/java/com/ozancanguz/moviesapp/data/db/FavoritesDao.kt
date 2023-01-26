package com.ozancanguz.moviesapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoritesDao {

    // fav products
    @Query("select* from favorites_table order by id asc")
    fun listallFavorites(): Flow<List<FavoritesEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavProduct(favoritesEntity: FavoritesEntity)

}