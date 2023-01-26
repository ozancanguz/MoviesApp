package com.ozancanguz.moviesapp.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.ozancanguz.moviesapp.data.db.FavoritesEntity
import com.ozancanguz.moviesapp.data.model.searchbyid.SearchByIdModel
import com.ozancanguz.moviesapp.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SearchByIdViewModel @Inject constructor(private val repository: Repository,application: Application):AndroidViewModel(application){

    // retrofit
    var searchByIdList=MutableLiveData<SearchByIdModel>()


    // room
    var favProductList: LiveData<List<FavoritesEntity>> = repository.local.listAllFavoritesProducts().asLiveData()


    // for room insert fav call
    fun insertFavoriteProduct(favoritesEntity: FavoritesEntity){
        viewModelScope.launch {
            repository.local.insertFavorites(favoritesEntity)
        }
    }



    // retrofit function
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