package com.ozancanguz.moviesapp.di

import android.content.Context
import android.graphics.Movie
import androidx.room.Room
import com.ozancanguz.moviesapp.data.db.MovieDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        MovieDatabase::class.java,
        "movie_database"
    ).build()

    @Singleton
    @Provides
    fun provideDao(database: MovieDatabase) = database.favoritesDao()

}

