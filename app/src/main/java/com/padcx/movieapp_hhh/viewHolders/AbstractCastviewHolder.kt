package com.padcx.movieapp_hhh.viewHolders

import android.view.View
import com.padcx.movieapp_hhh.data.vos.CastVO

abstract class AbstractCastviewHolder(itemView  : View) :BaseViewHolder(itemView) {
    var mCastData : CastVO? = null
}