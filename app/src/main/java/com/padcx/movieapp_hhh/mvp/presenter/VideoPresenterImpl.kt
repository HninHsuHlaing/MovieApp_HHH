package com.padcx.movieapp_hhh.mvp.presenter

import android.widget.VideoView
import androidx.lifecycle.LifecycleOwner
import com.padcx.movieapp_hhh.data.models.MovieModel
import com.padcx.movieapp_hhh.data.models.MovieModelImpl
import com.padcx.movieapp_hhh.mvp.view.VideosView

class VideoPresenterImpl : VideoPresenter, AbstractBasePresenter<VideosView>() {

    var mMovieImpl: MovieModel = MovieModelImpl

    override fun onUiReady(lifeCycleOwner: LifecycleOwner, movie_id: Int) {
        loadAllVideoFromAPI(movie_id)
    }
    private fun loadAllVideoFromAPI(movie_id: Int) {
        mMovieImpl.getVideoIdByMovieId(
            movie_id,
            onSuccess = {
                mView?.displayVideo(videoId = it.get(0).key)
            },
            onError = {}
        )
    }
}