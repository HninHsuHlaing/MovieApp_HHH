package com.padcx.movieapp_hhh.viewHolders

import android.view.View
import com.padcx.movieapp_hhh.data.vos.ActorVO

abstract class AbstractActorViewHolder(itemView : View) : BaseViewHolder(itemView) {
    var mActorData : ActorVO? = null
   // abstract fun bindActorData(data: ActorVO)
}