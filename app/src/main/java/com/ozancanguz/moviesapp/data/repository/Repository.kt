package com.ozancanguz.moviesapp.data.repository

import com.ozancanguz.moviesapp.data.db.localdatasource.LocalDataSource
import com.ozancanguz.moviesapp.data.remotedatasource.RemoteDataSource
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class Repository@Inject constructor(private val remoteDataSource: RemoteDataSource,
localDataSource: LocalDataSource) {

    val remote=remoteDataSource
    var local=localDataSource
}