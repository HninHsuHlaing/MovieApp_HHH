package com.padcx.movieapp_hhh.persistent.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.padcx.movieapp_hhh.data.vos.ActorVO
import com.padcx.movieapp_hhh.data.vos.ResultVO

@Dao
interface ActorDaos {
    @Query("SELECT * FROM Actor_Table")
    fun getAllActorList(): LiveData<List<ActorVO>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllActorList(country: List<ActorVO>)
}