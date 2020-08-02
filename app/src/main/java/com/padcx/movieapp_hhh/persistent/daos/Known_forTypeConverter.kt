package com.padcx.movieapp_hhh.persistent.daos

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.padcx.movieapp_hhh.data.vos.KnownForActorVO


class Known_forTypeConverter {
    @TypeConverter
    fun toString(scroe : List<KnownForActorVO>): String{

        return Gson().toJson(scroe)
    }

    @TypeConverter
    fun toUserList(userListJsonString : String) : ArrayList<KnownForActorVO>{
        val userListtype = object : TypeToken<ArrayList<KnownForActorVO>>() {}.type
        return Gson().fromJson(userListJsonString,userListtype)
    }
}