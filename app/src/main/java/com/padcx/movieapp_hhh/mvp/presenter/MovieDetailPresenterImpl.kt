package com.padcx.movieapp_hhh.mvp.presenter

import android.util.Log
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
           // mView?.displayActorListDetail(it)
        })


    }

    override fun onCreatorUiReady(lifeCycleOwner: LifecycleOwner) {
        mMovieModel.getactorList (onFailure = {

        }).observe(lifeCycleOwner, Observer {
           // mView?.displayCastCrewList()
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
        mMovieModel.getAllCrewAndCastFromApiAndSaveToDatabase(movie_id,onSuccess = {},onError = {})
        mMovieModel.getAllCastAndCrewList(movie_id,onError = {
            Log.e("display eror dat",it)
        }) .observe(lifeCycleOwner, Observer {
            it?.let {
                mView?.displayCastCrewList(it)
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

//    override fun onTapMovieITem(movie_id: Int) {
//
//    }
//
//    override fun onTapShowCaseItem(movie_id: Int) {
//
//    }


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