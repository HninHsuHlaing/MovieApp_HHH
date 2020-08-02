package com.padcx.movieapp_hhh.persistent.dbs

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.padcx.movieapp_hhh.data.vos.DiscoverVO
import com.padcx.movieapp_hhh.data.vos.GenerVO
import com.padcx.movieapp_hhh.persistent.daos.DiscoverDaos

@Database(entities = [DiscoverVO::class], version = 3,exportSchema = false)
abstract class DiscoverDb : RoomDatabase() {
    companion object{
        val Discover_DB= "Discover_Db"
        var dbinstnce :DiscoverDb?= null
        fun getDBInstance(context: Context):DiscoverDb{
            when (dbinstnce){
                null->{
                    dbinstnce = Room.databaseBuilder(context, DiscoverDb::class.java, Discover_DB)
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
    abstract fun DiscoverDaos() : DiscoverDaos
}