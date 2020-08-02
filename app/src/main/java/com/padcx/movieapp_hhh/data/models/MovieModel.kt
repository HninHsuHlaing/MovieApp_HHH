package com.padcx.movieapp_hhh.data.models

import androidx.lifecycle.LiveData
import com.padcx.movieapp_hhh.data.vos.*
import io.reactivex.Observable

interface MovieModel {
    fun getPopularMovies(onFailure :(String) -> Unit) : LiveData<List<ResultVO>>
  //  fun getAllPopularMovieFromApi_andSaveToDB()
  fun getactorList(onFailure :(String) -> Unit) : LiveData<List<ActorVO>>

    fun getShowCaseList(onFailure: (String) -> Unit) : LiveData<List<ShowCaseVO>>

    fun getGenerList(onFailure: (String) -> Unit) : LiveData<List<GenerVO>>
    fun getAllDiscoverList(genericname: String,onError: (String) -> Unit) : LiveData<List<DiscoverVO>>

  fun getAllDiscoverList(movieId: Int) : Observable<MovieDetailsVO>


    fun getAllDiscoverListFromApiAndSaveToDatabase(genericname: String, onSuccess: (List<DiscoverVO>) -> Unit, onError: (String) -> Unit)

    fun getMovieDetailById(movieId: Int) : LiveData<MovieDetailsVO>

  fun getMovieDetailFromApiAndSaveToDatabase(movieId: Int, onSuccess: () -> Unit, onError: (String) -> Unit)
}