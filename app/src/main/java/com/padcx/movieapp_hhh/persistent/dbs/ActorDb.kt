package com.padcx.movieapp_hhh.persistent.dbs

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.padcx.movieapp_hhh.data.vos.ActorVO
import com.padcx.movieapp_hhh.data.vos.ResultVO
import com.padcx.movieapp_hhh.persistent.daos.ActorDaos

@Database(entities = [ResultVO::class,ActorVO::class], version = 3,exportSchema = false)
abstract  class ActorDb  :RoomDatabase(){

    companion object{
        val Actor_DB = "Actor_Db"
        var dbinstnce :ActorDb?= null
        fun getDBInstance(context: Context):ActorDb{
            when (dbinstnce){
                null->{
                    dbinstnce = Room.databaseBuilder(context,ActorDb::class.java, Actor_DB)
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
    abstract fun ActorDaos() : ActorDaos
}