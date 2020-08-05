package com.padcx.movieapp_hhh.network.responses

import com.google.gson.annotations.SerializedName
import com.padcx.movieapp_hhh.data.vos.VideoVO


data class GetVideoResponse(
    @SerializedName("results")  val results: ArrayList<VideoVO?>? = null
)
