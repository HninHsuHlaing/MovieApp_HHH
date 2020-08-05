package com.padcx.movieapp_hhh.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.padcx.movieapp_hhh.data.models.MovieModelImpl
import com.padcx.movieapp_hhh.data.vos.DiscoverVO
import com.padcx.movieapp_hhh.mvp.view.MovieView


class DiscoverPresenterImpl : DiscoverPrsenter, AbstractBasePresenter<MovieView>() {

    var mMovieImpl = MovieModelImpl

    override fun onDiscoverUiReady(lifeCycleOwner: LifecycleOwner, mname: String) {

        mMovieImpl.getAllDiscoverListFromApiAndSaveToDatabase(
            genericname = mname,
            onSuccess = {
                mView?.displayMovieList(it)
            },
            onError = {}
        )

        mMovieImpl.getAllDiscoverList(
            mname,
            onError = {})
            .observe(lifeCycleOwner, Observer {
                it?.let {
                   mView?.displayMovieList(it)
                }

            })
    }

    override fun onDiscoverReady(generid: Int) {
        mMovieImpl.getAllDiscoverList(generid)
    }


    override fun onTapDiscoverListItem(entity: DiscoverVO) {

    }


}