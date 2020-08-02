package com.padcx.movieapp_hhh.persistent.dbs

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import com.padcx.movieapp_hhh.data.vos.ResultVO
import com.padcx.movieapp_hhh.data.vos.ShowCaseVO
import com.padcx.movieapp_hhh.persistent.daos.ActorDaos
import com.padcx.movieapp_hhh.persistent.daos.ShowCaseDaos

@Database(entities = [ShowCaseVO::class], version = 4,exportSchema = false)
abstract class ShowCaseDb :RoomDatabase(){
    companion object{
        val showCase_Db= "ShowCase_Db"
        var dbinstnce :ShowCaseDb?= null
        fun getDBInstance(context: Context):ShowCaseDb{
            when (dbinstnce){
                null->{
                    dbinstnce = databaseBuilder(context,ShowCaseDb::class.java, showCase_Db)
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
    abstract fun ShowCaseDaos() : ShowCaseDaos
}