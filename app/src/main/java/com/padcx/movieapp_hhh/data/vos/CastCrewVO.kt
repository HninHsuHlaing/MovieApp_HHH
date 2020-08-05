package com.padcx.movieapp_hhh.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.padcx.movieapp_hhh.typeConverters.CastTypeConverter
import com.padcx.movieapp_hhh.typeConverters.CrewTypeConverter


@Entity(tableName = "castcrew")
@TypeConverters(CastTypeConverter::class, CrewTypeConverter::class)
data class CastCrewVO
    (
    @PrimaryKey
    @SerializedName("id") var sid: Int,
    @SerializedName("crew")  var crew : ArrayList<CrewVO> = arrayListOf(),
    @SerializedName("cast")     var cast : ArrayList<CastVO> = arrayListOf()
)
{}