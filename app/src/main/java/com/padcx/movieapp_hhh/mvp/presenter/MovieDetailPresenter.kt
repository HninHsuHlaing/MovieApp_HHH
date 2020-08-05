package com.padcx.movieapp_hhh.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import com.padcx.movieapp_hhh.data.models.MovieModel
import com.padcx.movieapp_hhh.data.models.MovieModelImpl
import com.padcx.movieapp_hhh.delegate.DetailDelegate
//import com.padcx.movieapp_hhh.delegate.MovieDetailDelegate
import com.padcx.movieapp_hhh.mvp.view.MovieDetailView

interface MovieDetailPresenter  :BasePresenter<MovieDetailView>{

    fun onUiReady(lifeCycleOwner: LifecycleOwner)
    fun onCreatorUiReady(lifeCycleOwner: LifecycleOwner)
    fun onDetailUiReady(lifeCycleOwner: LifecycleOwner,movieid: Int)
    fun onSchowCaseUIDetailReady(lifeCycleOwner: LifecycleOwner,movieid: Int)
}