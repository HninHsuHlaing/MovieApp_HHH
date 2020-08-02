package com.padcx.movieapp_hhh.viewHolders

import android.view.View
import com.padcx.movieapp_hhh.data.vos.ActorVO
import com.padcx.movieapp_hhh.data.vos.DiscoverVO

abstract class AbstractActorForDetailPageViewHolder(itemView : View) :BaseViewHolder(itemView) {
    var mActorData : ActorVO? = null
}