package com.padcx.movieapp_hhh.persistent.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.padcx.movieapp_hhh.data.vos.ActorVO
import com.padcx.movieapp_hhh.data.vos.ShowCaseVO

@Dao
interface ShowCaseDaos {
    @Query("SELECT * FROM ShowCase_Table")
    fun getAllActorList(): LiveData<List<ShowCaseVO>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllActorList(country: List<ShowCaseVO>)
}