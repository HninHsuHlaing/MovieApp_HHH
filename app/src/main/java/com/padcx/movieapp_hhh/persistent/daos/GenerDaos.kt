package com.padcx.movieapp_hhh.persistent.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.padcx.movieapp_hhh.data.vos.ActorVO
import com.padcx.movieapp_hhh.data.vos.GenerVO

@Dao
interface GenerDaos {
    @Query("SELECT * FROM Gener_table")
    fun getAllActorList(): LiveData<List<GenerVO>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllActorList(country: List<GenerVO>)
}