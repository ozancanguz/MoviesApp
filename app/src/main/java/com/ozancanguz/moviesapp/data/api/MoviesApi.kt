package com.ozancanguz.moviesapp.data.api

import com.ozancanguz.moviesapp.data.model.searchbyid.SearchByIdModel
import com.ozancanguz.moviesapp.data.model.searchbyname.SearchByName
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface MoviesApi {

    // search by name
    @Headers(
        "authorization: apikey 2xAW88zA1iemGAxzWMNumI:47IyS3uICCasjqzWaFtxnn",
        "content-type: application/json"
    )
    @GET("imdbSearchByName")
    suspend fun searchFilmByName(@Query("query")query: String):Response<SearchByName>


// search by imdb id
    @Headers(
        "authorization: apikey 2xAW88zA1iemGAxzWMNumI:47IyS3uICCasjqzWaFtxnn",
        "content-type: application/json"
    )
    @GET("imdbSearchById")
    suspend fun searchById(@Query("movieId")movieId:String):Response<SearchByIdModel>




}