package com.padcx.movieapp_hhh.mvp.view

import com.padcx.movieapp_hhh.data.vos.*

interface MovieDetailView : BaseView{
    fun displayActorListDetail(list: List<CastVO>)
    fun displayCreatorList(list: List<CrewVO>)
    fun displayMovieDetail(moviedetail: MovieDetailsVO)
    fun displayCastCrewList(list: CastCrewVO)
}