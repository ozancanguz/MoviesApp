package com.ozancanguz.moviesapp.data.remotedatasource

import com.ozancanguz.moviesapp.data.api.MoviesApi
import com.ozancanguz.moviesapp.data.model.searchbyid.SearchByIdModel
import com.ozancanguz.moviesapp.data.model.searchbyname.SearchByName
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val moviesApi: MoviesApi){


    suspend fun searchFilmByName(query:String): Response<SearchByName> {

        return moviesApi.searchFilmByName(query)
    }


    suspend fun searchFilmById(movieId:String):Response<SearchByIdModel>{
        return moviesApi.searchById(movieId)
    }

}