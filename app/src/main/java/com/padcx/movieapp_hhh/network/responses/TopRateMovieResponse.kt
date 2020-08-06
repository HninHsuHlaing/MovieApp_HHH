package com.padcx.movieapp_hhh.network.responses

import com.google.gson.annotations.SerializedName
import com.padcx.movieapp_hhh.data.vos.TopRateMovieVO

data class TopRateMovieResponse(
    @SerializedName("results")  val results: ArrayList<TopRateMovieVO?>? = null
)
