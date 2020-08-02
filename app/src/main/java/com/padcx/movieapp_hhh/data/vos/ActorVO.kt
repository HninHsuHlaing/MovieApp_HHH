package com.padcx.movieapp_hhh.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.padcx.movieapp_hhh.persistent.daos.GenredListTypeConverter
import com.padcx.movieapp_hhh.persistent.daos.Known_forTypeConverter

@Entity(tableName = "Actor_Table")
@TypeConverters(Known_forTypeConverter::class)
data class ActorVO(

    @SerializedName("popularity")
    var popularity :Double = 0.0,

    @SerializedName("known_for_department")
    var knownForDepartment : String = "",
    @SerializedName("gender")
    var gender :Int = 0,

    @PrimaryKey
    @SerializedName("id")
    var id :Int = 0,
    @SerializedName("profile_path")
    var profilePath :String = "",
    @SerializedName("adult")
    var adult : Boolean = true,


    @SerializedName("known_for")
    var known_for : ArrayList<KnownForActorVO> = arrayListOf(),
    @SerializedName("name")
    var name :String = ""

)