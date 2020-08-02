package com.padcx.movieapp_hhh.mvp.view

import com.padcx.movieapp_hhh.data.vos.ActorVO
import com.padcx.movieapp_hhh.data.vos.MovieDetailsVO

interface MovieDetailView : BaseView{
    fun displayActorListDetail(list: List<ActorVO>)
    fun displayCreatorList(list: List<ActorVO>)
    fun displayMovieDetail(moviedetail: MovieDetailsVO)
}