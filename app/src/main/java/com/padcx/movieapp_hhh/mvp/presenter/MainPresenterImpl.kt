package com.padcx.movieapp_hhh.mvp.presenter

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.padcx.movieapp_hhh.data.models.MovieModel
import com.padcx.movieapp_hhh.data.models.MovieModelImpl
import com.padcx.movieapp_hhh.data.vos.MovieDetailsVO
import com.padcx.movieapp_hhh.data.vos.PopularMovieVO
import com.padcx.movieapp_hhh.mvp.view.BaseView
import com.padcx.movieapp_hhh.mvp.view.MainView
import com.padcx.movieapp_hhh.util.PARAM_API_KEY

class MainPresenterImpl : AbstractBasePresenter<MainView>(), MainPresenter {
     var mMovieModel : MovieModel =  MovieModelImpl
    override fun onUiReady(lifeCycleOwner: LifecycleOwner) {
        mMovieModel.getPopularMovies(onFailure = {

        }).observe(lifeCycleOwner, Observer {
            mView?.displayPopularMovieList(it)
        })
    }

    override fun onActorUiReady(lifeCycleOwner: LifecycleOwner) {
        mMovieModel.getactorList(onFailure = {

        }).observe(lifeCycleOwner, Observer {
            mView?.displayActorList(it)
        })
    }

    override fun onShowCaseUIReady(lifeCycleOwner: LifecycleOwner) {
        mMovieModel.getShowCaseList(onFailure = {

        }).observe(lifeCycleOwner, Observer {
            mView?.displayShowcaseeMovieList(it)
        })
    }

    override fun onShowGenerUIReady(lifeCycleOwner: LifecycleOwner) {
        mMovieModel.getGenerList (onFailure = {

        }).observe(lifeCycleOwner , Observer {
            mView?.showGenerList(it)
        })
    }

    override fun onTapListItem(entity: MovieDetailsVO) {
    //    mView?.navigatetodetailView(entity.id)
    }

    override fun onTapMovieITem(movie_id : Int) {
        mView?.navigateToactorDetail(movie_id)
    }

    override fun onTapShowCaseItem(movie_id: Int) {
        mView?.navigateToactorDetail(movie_id)

    }

//    override fun onTapPopularMovieItem(entity : MovieDetailsVO) {
//        mView?.navigatetodetailView(entity.id)
//    }


//    override fun intiPresenter(view: MainView) {
//            mView = view
//    }

//    override fun onTapPopularMovieItem() {
//       // mView?.navigatetodetailView()
//    }

//    override fun onTapActorItem() {
//       mView?.navigateToactorDetail()
//    }


//    override fun onTapMovieItem(movieId: Int) {
//        mView?.navigatetodetailView(movieId)
//    }
}