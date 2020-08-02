package com.padcx.movieapp_hhh.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.padcx.movieapp_hhh.data.models.MovieModel
import com.padcx.movieapp_hhh.data.models.MovieModelImpl
import com.padcx.movieapp_hhh.mvp.view.MovieDetailView

class MovieDetailPresenterImpl : MovieDetailPresenter, AbstractBasePresenter<MovieDetailView>() {
    var mMovieModel : MovieModel =  MovieModelImpl
    override fun onUiReady(lifeCycleOwner: LifecycleOwner) {
        mMovieModel.getactorList(onFailure = {

        }).observe(lifeCycleOwner, Observer {
            mView?.displayActorListDetail(it)
        })


    }

    override fun onCreatorUiReady(lifeCycleOwner: LifecycleOwner) {
        mMovieModel.getactorList (onFailure = {

        }).observe(lifeCycleOwner, Observer {
            mView?.displayCreatorList(it)
        })
    }

    override fun onDetailUiReady(lifeCycleOwner: LifecycleOwner, movie_id: Int) {
        mMovieModel.getMovieDetailFromApiAndSaveToDatabase(
            movieId = movie_id,
            onSuccess = {},
            onError = {}
        )
        mMovieModel.getMovieDetailById(
            movie_id
            )
            .observe(lifeCycleOwner, Observer {
                it?.let {
                    mView?.displayMovieDetail(it)
                }

            })
    }

    override fun onSchowCaseUIDetailReady(lifeCycleOwner: LifecycleOwner, movie_id: Int) {
        mMovieModel.getMovieDetailFromApiAndSaveToDatabase(
            movieId = movie_id,
            onSuccess = {},
            onError = {}
        )
        mMovieModel.getMovieDetailById(
            movie_id
        )
            .observe(lifeCycleOwner, Observer {
                it?.let {
                    mView?.displayMovieDetail(it)
                }

            })
    }

//    override fun onTap() {
//
//    }

//    override fun onTapMovieItem(movieId: Int) {
//        mMovieModel.getMovieDetailFromApiAndSaveToDatabase(
//            movieId = movieId,
//            onSuccess = {},
//            onError = {}
//        )
//        mMovieModel.getMovieDetailById(movieId,onError = {})
//
//    }
}