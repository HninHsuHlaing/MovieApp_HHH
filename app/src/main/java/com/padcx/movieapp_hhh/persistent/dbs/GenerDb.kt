package com.padcx.movieapp_hhh.persistent.dbs

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase

import com.padcx.movieapp_hhh.data.vos.GenerVO
import com.padcx.movieapp_hhh.data.vos.ResultVO
import com.padcx.movieapp_hhh.persistent.daos.GenerDaos

@Database(entities = [GenerVO::class], version = 3,exportSchema = false)
abstract class GenerDb :RoomDatabase() {
    companion object{
        val Gener_Db= "Gener_Db"
        var dbinstnce :GenerDb?= null
        fun getDBInstance(context: Context):GenerDb{
            when (dbinstnce){
                null->{
                    dbinstnce = databaseBuilder(context,GenerDb::class.java, Gener_Db)
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
    abstract fun GenerDaos() : GenerDaos
}