package com.padcx.movieapp_hhh.network.responses

import com.google.gson.annotations.SerializedName
import com.padcx.movieapp_hhh.data.vos.ShowCaseVO

data class GetShowCaseResponse(

    @SerializedName("results")
    var result : ArrayList<ShowCaseVO> = arrayListOf()
)
