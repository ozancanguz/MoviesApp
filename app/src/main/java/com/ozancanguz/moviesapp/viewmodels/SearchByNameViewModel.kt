package com.ozancanguz.moviesapp.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ozancanguz.moviesapp.data.model.searchbyname.SearchByName
import com.ozancanguz.moviesapp.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.http.Query
import javax.inject.Inject

@HiltViewModel
class SearchByNameViewModel @Inject constructor(private val repository: Repository,application: Application):AndroidViewModel(application) {


    var searchbyNameFilms=MutableLiveData<SearchByName>()



    fun searchFilmsByName(query: String){
        viewModelScope.launch {
            val response=repository.remote.searchFilmByName(query)
            if(response.isSuccessful){
                searchbyNameFilms.postValue(response.body())
            }else{
                Log.d("searchname","No data")
            }
        }
    }




}