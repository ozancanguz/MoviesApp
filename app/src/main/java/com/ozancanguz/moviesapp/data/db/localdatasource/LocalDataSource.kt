package com.ozancanguz.moviesapp.data.db.localdatasource

import androidx.room.Dao
import com.ozancanguz.moviesapp.data.db.FavoritesDao
import com.ozancanguz.moviesapp.data.db.FavoritesEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSource@Inject constructor(private val favoriteDao: FavoritesDao) {

// for favorites product

    fun listAllFavoritesProducts(): Flow<List<FavoritesEntity>> {
        return favoriteDao.listallFavorites()
    }

    suspend fun insertFavorites(favoritesEntity: FavoritesEntity){
        return favoriteDao.insertFavProduct(favoritesEntity)
    }
}