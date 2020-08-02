package com.padcx.movieapp_hhh.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.padcx.movieapp_hhh.persistent.daos.GenredListTypeConverter

@Entity(tableName = "ShowCase_Table")
@TypeConverters(GenredListTypeConverter::class)
data class ShowCaseVO (

    @SerializedName("popularity")
    var popularity : Double = 0.0,
    @SerializedName("vote_count")
    var vote_count : Int = 0,
    @SerializedName("video")
    var video : Boolean = true,
    @SerializedName("poster_path")
    var poster_path : String = "",

    @PrimaryKey
    @SerializedName("id")
    var id : Int = 0,
    @SerializedName("adult")
    var adult : Boolean = true,
    @SerializedName("backdrop_path")
    var backdrop_path : String? = null ,
    @SerializedName("original_language")
    var original_language : String = "",
    @SerializedName("original_title")
    var original_title : String  ="",

    @SerializedName("genre_ids")
    var grner_id : ArrayList<Int> = arrayListOf(),

    @SerializedName("title")
    var title : String = "",
    @SerializedName("vote_average")
    var voteAverage : Double = 0.0,
    @SerializedName("overview")
    var overView : String = " ",
    @SerializedName("release_date")
    var releaseDate :String = ""
)