package com.padcx.movieapp_hhh.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import com.padcx.movieapp_hhh.data.vos.MovieDetailsVO
import com.padcx.movieapp_hhh.data.vos.PopularMovieVO
import com.padcx.movieapp_hhh.delegate.DetailDelegate
import com.padcx.movieapp_hhh.mvp.view.MainView

interface MainPresenter :BasePresenter<MainView> ,DetailDelegate {
    fun onUiReady(lifeCycleOwner: LifecycleOwner)
    fun onActorUiReady(lifeCycleOwner: LifecycleOwner)
    fun onShowCaseUIReady(lifeCycleOwner: LifecycleOwner)

    fun onShowGenerUIReady(lifeCycleOwner: LifecycleOwner)

    fun onTapListItem(entity : MovieDetailsVO)
}