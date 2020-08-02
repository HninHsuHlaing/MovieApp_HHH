package com.padcx.movieapp_hhh.mvp.view

import com.padcx.movieapp_hhh.data.vos.ActorVO
import com.padcx.movieapp_hhh.data.vos.GenerVO
import com.padcx.movieapp_hhh.data.vos.ResultVO
import com.padcx.movieapp_hhh.data.vos.ShowCaseVO

interface MainView  : BaseView{
    fun displayPopularMovieList(list: List<ResultVO>)
    fun displayShowcaseeMovieList(list : List<ShowCaseVO>)
    fun displayActorList(list: List<ActorVO>)
//    fun navigatetodetailView(mvoid_id: Int)
    fun navigateToactorDetail(movie_id : Int)

    fun showGenerList(list: List<GenerVO>)
}