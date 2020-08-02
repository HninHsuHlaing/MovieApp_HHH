package com.padcx.movieapp_hhh

import android.app.Application
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
//import com.module2.networkcallproj.Data.data.models.TourNewsModelImpl
//import com.module2.networkcallproj.workers.GetNewsWorker
import com.padcx.movieapp_hhh.data.models.MovieModelImpl

class MovieApp: Application() {
    override fun onCreate() {
        super.onCreate()
        MovieModelImpl.initDatabase(applicationContext)
      //  getNewsOneTime()
    }
//    private fun getNewsOneTime(){
//        val getEventsWorkRequest = OneTimeWorkRequest
//            .Builder(GetNewsWorker::class.java)
//            .build()
//        WorkManager.getInstance(applicationContext)
//            .enqueue(getEventsWorkRequest)
//    }
}