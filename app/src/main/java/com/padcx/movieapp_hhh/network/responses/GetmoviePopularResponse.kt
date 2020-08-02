package com.padcx.movieapp_hhh.network.responses

import com.google.gson.annotations.SerializedName
import com.padcx.movieapp_hhh.data.vos.ResultVO

data class GetmoviePopularResponse( @SerializedName("page")
                                    var code :Int = 0,
                                    @SerializedName("total_results")
                                    var totalResult : String = "",
                                    @SerializedName("total_pages")
                                    var toatlPage : String = "",
                                    @SerializedName("results")
                                    var result : List<ResultVO> = arrayListOf()) {
    fun isResponseOk() =  (result != null)
}