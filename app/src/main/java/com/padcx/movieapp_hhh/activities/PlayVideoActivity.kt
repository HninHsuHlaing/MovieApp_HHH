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
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=S0Q4gqBUs7c"))
            return intent
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_play_video)

       // var intent  = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=S0Q4gqBUs7c"))
        this.startActivity(intent)

    }
}
