package com.padcx.movieapp_hhh

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.padcx.movieapp_hhh.data.vos.ActorVO
import com.padcx.movieapp_hhh.data.vos.PopularMovieVO
import com.padcx.movieapp_hhh.data.vos.ResultVO
import com.padcx.movieapp_hhh.data.vos.ShowCaseVO
import com.padcx.movieapp_hhh.persistent.daos.ActorDaos
import com.padcx.movieapp_hhh.persistent.daos.PopularMovieDaos
import com.padcx.movieapp_hhh.persistent.daos.ShowCaseDaos
import com.padcx.movieapp_hhh.persistent.dbs.ActorDb
import com.padcx.movieapp_hhh.persistent.dbs.Populardb
import com.padcx.movieapp_hhh.persistent.dbs.ShowCaseDb
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class InstrumentationTest {

    private lateinit var mMovieDaos : PopularMovieDaos
    private lateinit var mMoviewDb :Populardb
    private lateinit var  mActorDaos : ActorDaos
    private lateinit var  mActorDb : ActorDb


    @Before
        fun setUpDb(){
        val context= ApplicationProvider.getApplicationContext<Context>()
        mMoviewDb = Room.inMemoryDatabaseBuilder(context,Populardb::class.java).build()
        mMovieDaos = mMoviewDb.PopularMovieDaos()

        mActorDb = Room.inMemoryDatabaseBuilder(context,ActorDb::class.java).build()
        mActorDaos = mActorDb.ActorDaos()

    }
    @After
    fun closeDB(){
        mMoviewDb.close()
        mActorDb.close()
    }

    @Test
    fun databaseTest(){
        val movieOne= ResultVO()
        movieOne.original_title = "Constantine"
        movieOne.id = 10101010

        val movieTwo= ResultVO()
        movieOne.original_title = "Constantine"
        movieOne.id = 10101011

        var movieList : MutableList<ResultVO> = arrayListOf()
        movieList.add(movieOne)
        movieList.add(movieTwo)


        mMovieDaos.insertAllPopularMovie(movieList)
    }

    @Test
    fun ActordatabaseTest(){
        val actorOne = ActorVO()
        actorOne.name = "Jonh "
        actorOne.id = 20201

        val actorTwo = ActorVO()
        actorTwo.name = "Koe Koe"
        actorTwo.id = 20202

        var actorList : MutableList<ActorVO> = arrayListOf()
        actorList.add(actorOne)
        actorList.add(actorTwo)
        mActorDaos.insertAllActorList(actorList)
    }



}