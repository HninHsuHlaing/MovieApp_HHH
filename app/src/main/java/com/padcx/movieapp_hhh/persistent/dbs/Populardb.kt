package com.padcx.movieapp_hhh.persistent.dbs

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.padcx.movieapp_hhh.data.vos.CastCrewVO
import com.padcx.movieapp_hhh.data.vos.MovieDetailsVO
import com.padcx.movieapp_hhh.data.vos.ResultVO
import com.padcx.movieapp_hhh.persistent.daos.PopularMovieDaos

@Database(entities = [ResultVO::class, MovieDetailsVO::class, CastCrewVO::class], version = 6,exportSchema = false)
abstract class Populardb : RoomDatabase() {
    companion object{
        val Tour_DB= "PopularMovie_DB"
        var dbinstnce :Populardb?= null
        fun getDBInstance(context: Context):Populardb{
            when (dbinstnce){
                null->{
                    dbinstnce = Room.databaseBuilder(context,Populardb::class.java, Tour_DB)
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        //.addMigrations(MIGRATION_1_4, MIGRATION_4_5, MIGRATION_5_6)
                        .build()
                }

            }
            val i = dbinstnce
            return i!!

        }
    }
    abstract fun PopularMovieDaos() : PopularMovieDaos
}