package com.ozancanguz.moviesapp.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "favorites_table")
data class FavoritesEntity(

    @PrimaryKey(autoGenerate = true)
    var id:Int=0,
    var movies:com.ozancanguz.moviesapp.data.model.searchbyid.Result


) {
}