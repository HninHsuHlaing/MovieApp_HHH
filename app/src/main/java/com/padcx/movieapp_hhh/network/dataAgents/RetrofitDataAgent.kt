package com.padcx.movieapp_hhh.network.dataAgents

import android.util.Log
import com.padcx.movieapp_hhh.MovieApi
import com.padcx.movieapp_hhh.data.vos.ResultVO
import com.padcx.movieapp_hhh.network.responses.GetmoviePopularResponse
import com.padcx.movieapp_hhh.util.BASE_URL
import com.padcx.movieapp_hhh.util.No_INTERNET_CONNECTION
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import kotlin.math.log

object RetrofitDataAgent : MovieDataAgent{
    private  var mMovieApi : MovieApi? = null


    init {

        val mOkHttpClient = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(mOkHttpClient)
            .build()
        mMovieApi = retrofit.create(MovieApi::class.java)
    }



//    override fun getPopularMovie(
//        apiKey: String,
//        onSuccess: (List<ResultVO>) -> Unit,
//        onfailure: (String) -> Unit) {
//        val getPopularMovieCall = mMovieApi?.getPopularMoveList(apiKey)
//        getPopularMovieCall?.enqueue(object : Callback<GetmoviePopularResponse>{
//            override fun onFailure(call: Call<GetmoviePopularResponse>, t: Throwable) {
//                Log.d("tag","Network Failure")
//            }
//
//            override fun onResponse(
//                call: Call<GetmoviePopularResponse>,
//                response: Response<GetmoviePopularResponse>
//            ) {
//                val getAllPopularMovieRespone= response.body()
//                if (getAllPopularMovieRespone != null){
//                    if(getAllPopularMovieRespone.isResponseOk()){
//                        getAllPopularMovieRespone.result.let {
//                            onSuccess(it)
//                        }
//                    }else{
//                        onfailure(Log.d("tag","Response is not ok").toString())
//                    }
//
//                }else{
//                    onfailure(No_INTERNET_CONNECTION)
//                }
//            }
//
//        })
//
//    }




}