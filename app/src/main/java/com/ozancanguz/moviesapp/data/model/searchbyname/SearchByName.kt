package com.ozancanguz.moviesapp.data.model.searchbyname


import com.google.gson.annotations.SerializedName

data class SearchByName(
    @SerializedName("result")
    val result: List<SearchNameResult>,
    @SerializedName("success")
    val success: Boolean
)