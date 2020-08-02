package com.padcx.movieapp_hhh.persistent.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.padcx.movieapp_hhh.data.vos.DiscoverVO

@Dao
interface DiscoverDaos {
    @Query("select * from discover")
    fun getAllDiscoverList(): LiveData<List<DiscoverVO>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDiscoverData(generic: List<DiscoverVO?>)
}