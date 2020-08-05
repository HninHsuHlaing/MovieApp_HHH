package com.padcx.movieapp_hhh.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import com.padcx.movieapp_hhh.mvp.view.VideosView


interface VideoPresenter : BasePresenter<VideosView> {
    fun onUiReady(lifeCycleOwner: LifecycleOwner, movieid: Int)
}
