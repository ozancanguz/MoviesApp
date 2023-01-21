package com.ozancanguz.moviesapp.data.model.searchbyid


import com.google.gson.annotations.SerializedName

data class SearchByIdModel(
    @SerializedName("result")
    val result: Result,
    @SerializedName("success")
    val success: Boolean
)