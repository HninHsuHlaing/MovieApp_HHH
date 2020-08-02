package com.padcx.movieapp_hhh.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Gener_table")
data class GenerVO (
    @PrimaryKey
    var id : Int = 0,
    var name :String = ""

)