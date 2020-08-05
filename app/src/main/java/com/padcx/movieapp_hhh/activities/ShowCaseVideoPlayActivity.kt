package com.padcx.movieapp_hhh.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.NonNull
import com.padcx.movieapp_hhh.R
import com.padcx.movieapp_hhh.mvp.view.VideosView

class ShowCaseVideoPlayActivity : AppCompatActivity() ,VideosView{

    companion object {

        const val movieid = "Movie Id Extra"

        fun newItent(context: MainActivity, mId: Int): Intent {
            val intent = Intent(context, ShowCaseVideoPlayActivity::class.java)
            intent.putExtra(movieid, mId)
            return intent
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_case_video_play)
    }

//    private fun setUpVideoView(videoId: String)
//    {
//        lifecycle.addObserver(youtube_player_view)
//        youtube_player_view.enterFullScreen()
//        youtube_player_view.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
//            override fun onReady(@NonNull youTubePlayer: YouTubePlayer) {
//                youTubePlayer.loadVideo(videoId, 0f)
//            }
//        })
//    }

    override fun displayVideo(videoId: String) {

    }
}