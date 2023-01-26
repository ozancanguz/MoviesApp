package com.ozancanguz.moviesapp.data.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ozancanguz.moviesapp.data.model.searchbyid.Result

class TypeConverter {

    var gson = Gson()

    @TypeConverter
    fun ResultToString(result: com.ozancanguz.moviesapp.data.model.searchbyid.Result):String{
        return gson.toJson(result)
    }

    @TypeConverter
    fun stringToResult(data:String):com.ozancanguz.moviesapp.data.model.searchbyid.Result{
        val listType=object : TypeToken<com.ozancanguz.moviesapp.data.model.searchbyid.Result>(){
        }.type
        return gson.fromJson(data,listType)
    }
}