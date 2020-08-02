package com.padcx.movieapp_hhh.data.models

import androidx.lifecycle.LiveData
import com.padcx.movieapp_hhh.MovieApi
import com.padcx.movieapp_hhh.data.vos.ResultVO
import com.padcx.movieapp_hhh.network.dataAgents.MovieDataAgent
import com.padcx.movieapp_hhh.network.dataAgents.RetrofitDataAgent
import com.padcx.movieapp_hhh.persistent.dbs.*
import com.padcx.movieapp_hhh.util.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

abstract class BaseModel {
   protected  var mMovieApi : MovieApi
    protected lateinit var mPopularMovieDB : Populardb
   protected lateinit var mActorMovieDb : ActorDb
   protected lateinit var mShowCaseDb : ShowCaseDb
   protected lateinit var mGenerDb : GenerDb
   protected lateinit var mDiscoverDb : DiscoverDb
   val mDataAgent : MovieDataAgent = RetrofitDataAgent
   init {

      val mOkHttpClient = OkHttpClient.Builder()
         .connectTimeout(15, TimeUnit.SECONDS)
         .readTimeout(15, TimeUnit.SECONDS)
         .writeTimeout(15, TimeUnit.SECONDS)
         .build()

      val retrofit = Retrofit.Builder()
         .baseUrl(BASE_URL)
         .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
         .addConverterFactory(GsonConverterFactory.create())
         .client(mOkHttpClient)
         .build()

      mMovieApi = retrofit.create(MovieApi::class.java)
   }
}