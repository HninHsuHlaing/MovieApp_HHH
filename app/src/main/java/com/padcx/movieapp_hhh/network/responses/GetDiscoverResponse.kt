package com.padcx.movieapp_hhh.network.responses

import com.google.gson.annotations.SerializedName
import com.padcx.movieapp_hhh.data.vos.DiscoverVO


data class GetDiscoverResponse(
    @SerializedName("results")  val results: ArrayList<DiscoverVO?>
)
