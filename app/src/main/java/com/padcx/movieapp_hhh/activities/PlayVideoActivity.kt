package com.padcx.movieapp_hhh.activities

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import com.padcx.movieapp_hhh.R
import kotlinx.android.synthetic.main.activity_play_video.*

class PlayVideoActivity : AppCompatActivity() {

    companion object{
        fun newInstant(context: Context): Intent {
            val intent = Intent(context,PlayVideoActivity::class.java)
            return intent
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_video)

//        val mediaController : MediaController = MediaController(this)
//        mediaController.setAnchorView(videoView)
//        val uri: Uri = Uri.parse("https://youtu.be/zClabIdSmhw")
//        videoView.setMediaController(mediaController)
//        videoView.setVideoURI(uri)
//        videoView.start()

//        https://www.youtube.com/watch?v=sUjoDA0fx8s
        //http://www.ebookfrenzy.com/android_book/movie.mp4

        videoView.setVideoPath("http://www.ebookfrenzy.com/android_book/movie.mp4")
        videoView.start()
       // videoView.seekTo(1)


    }
}
