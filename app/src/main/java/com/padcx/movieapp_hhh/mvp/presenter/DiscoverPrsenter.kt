package com.padcx.movieapp_hhh.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import com.padcx.movieapp_hhh.delegate.PopularMovieListDelegate
import com.padcx.movieapp_hhh.mvp.view.MovieView

interface DiscoverPrsenter : BasePresenter<MovieView>, PopularMovieListDelegate {
    fun onDiscoverUiReady(lifeCycleOwner: LifecycleOwner, genericid: String)
    fun onDiscoverReady(generid : Int)
}
