package com.padcx.movieapp_hhh.network.responses

import com.google.gson.annotations.SerializedName
import com.padcx.movieapp_hhh.data.vos.ActorVO

data class GetActorResponse (

    @SerializedName("page")
        var page : Int = 0,
    @SerializedName("total_results")
        var totalResults : Int = 0,
    @SerializedName("total_pages")
        var totalPages : Int = 0,
    @SerializedName("results")
        var result: ArrayList<ActorVO> = arrayListOf()
)