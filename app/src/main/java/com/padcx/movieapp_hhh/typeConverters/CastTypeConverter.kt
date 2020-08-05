package com.padcx.movieapp_hhh.typeConverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.padcx.movieapp_hhh.data.vos.CastVO


class CastTypeConverter {
    @TypeConverter
    fun toString(dataList:ArrayList<CastVO>):String{
        return Gson().toJson(dataList)
    }

    @TypeConverter
    fun toCountryList(countryListJsonStr:String):ArrayList<CastVO>{
        val countryListType = object : TypeToken<ArrayList<CastVO>>(){}.type
        return Gson().fromJson(countryListJsonStr,countryListType)
    }
}