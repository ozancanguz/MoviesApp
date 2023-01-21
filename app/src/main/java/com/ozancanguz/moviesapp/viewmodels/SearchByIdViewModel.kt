package com.ozancanguz.moviesapp.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ozancanguz.moviesapp.data.model.searchbyid.SearchByIdModel
import com.ozancanguz.moviesapp.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SearchByIdViewModel @Inject constructor(private val repository: Repository,application: Application):AndroidViewModel(application){

    var searchByIdList=MutableLiveData<SearchByIdModel>()


    fun searchById(movieId:String){
        viewModelScope.launch {

            val response=repository.remote.searchFilmById(movieId)
            if(response.isSuccessful){
                searchByIdList.postValue(response.body())

            }else{
                Log.d("id","no data")
            }


        }

    }



}