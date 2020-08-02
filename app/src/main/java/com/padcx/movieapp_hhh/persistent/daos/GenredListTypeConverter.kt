package com.padcx.movieapp_hhh.persistent.daos

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class GenredListTypeConverter {
    @TypeConverter
    fun toString(scroe : List<Int>): String{

        return Gson().toJson(scroe)
    }

    @TypeConverter
    fun toUserList(userListJsonString : String) : ArrayList<Integer>{
        val userListtype = object : TypeToken<ArrayList<Integer>>() {}.type
        return Gson().fromJson(userListJsonString,userListtype)
    }
}