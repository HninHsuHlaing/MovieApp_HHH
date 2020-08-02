package com.padcx.movieapp_hhh.network.responses

import com.google.gson.annotations.SerializedName
import com.padcx.movieapp_hhh.data.vos.GenerVO

class GetGenerListResponse {

    @SerializedName("genres")
    var geners :  ArrayList<GenerVO> = arrayListOf()
}