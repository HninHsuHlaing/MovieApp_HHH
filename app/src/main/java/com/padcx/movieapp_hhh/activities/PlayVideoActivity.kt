package com.padcx.movieapp_hhh.activities

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.MediaController
import android.widget.VideoView
import androidx.lifecycle.ViewModelProviders
import com.padcx.movieapp_hhh.R
import com.padcx.movieapp_hhh.data.models.MovieModel
import com.padcx.movieapp_hhh.data.models.MovieModelImpl
import com.padcx.movieapp_hhh.mvp.presenter.VideoPresenter
import com.padcx.movieapp_hhh.mvp.presenter.VideoPresenterImpl
import com.padcx.movieapp_hhh.mvp.view.VideosView
import kotlinx.android.synthetic.main.activity_play_video.*

class PlayVideoActivity : AppCompatActivity(),VideosView{

    companion object{
        const val movieid = "Movie Id Extra"
        fun newInstant(context: Context, mId: Int): Intent {
            //val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=S0Q4gqBUs7c"))
            val intent = Intent(context,PlayVideoActivity::class.java)

            return intent
        }
    }

    private lateinit var mPresenter: VideoPresenter
     var mModel : MovieModel  =MovieModelImpl
    var uri : String = "https://www.youtube.com/watch?v=S0Q4gqBUs7c"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  setContentView(R.layout.activity_play_video)

       // var intent  = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=S0Q4gqBUs7c"))


        val movie_id = intent.getIntExtra(PlayVideoActivity.movieid, 0)
        setUpPresenter()

     mModel.getVideoIdByMovieId(movie_id,onSuccess = {
      //   intent = Intent(Intent.ACTION_VIEW, Uri.parse(it.get(0).key))

          uri = it.get(0).key
      //  System.out.println("Uri Value is "+ uri)
      },onError = {

     })
        intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
        this.startActivity(intent)



    }

    private fun setUpPresenter() {
        mPresenter =  ViewModelProviders.of(this).get(VideoPresenterImpl::class.java)
        mPresenter.intiPresenter(this)
    }

    override fun displayVideo(videoId: String) {

    }
}
