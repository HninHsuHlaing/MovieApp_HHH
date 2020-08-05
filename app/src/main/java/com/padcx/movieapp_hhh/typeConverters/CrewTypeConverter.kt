package com.padcx.movieapp_hhh.typeConverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.padcx.movieapp_hhh.data.vos.CrewVO


class CrewTypeConverter {
    @TypeConverter
    fun toString(dataList:ArrayList<CrewVO>):String{
        return Gson().toJson(dataList)
    }

    @TypeConverter
    fun toCountryList(countryListJsonStr:String):ArrayList<CrewVO>{
        val countryListType = object : TypeToken<ArrayList<CrewVO>>(){}.type
        return Gson().fromJson(countryListJsonStr,countryListType)
    }
}