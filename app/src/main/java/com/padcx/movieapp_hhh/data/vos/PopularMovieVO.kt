package com.padcx.movieapp_hhh.data.vos

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class PopularMovieVO(

    @SerializedName("page")
        var page :Int = 0,
    @SerializedName("total_results")
         var totalResult : String = "",
    @SerializedName("total_pages")
        var toatlPage : String = "",
    @SerializedName("results")
    var result : ArrayList<ResultVO> = arrayListOf()




)