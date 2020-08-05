package com.padcx.movieapp_hhh.viewHolders

import android.view.View
import com.padcx.movieapp_hhh.data.vos.CastVO
import com.padcx.movieapp_hhh.data.vos.CrewVO

abstract class AbstractCrewviewHolder(itemView  : View) :BaseViewHolder(itemView) {
    var mCrewData : CrewVO? = null
}