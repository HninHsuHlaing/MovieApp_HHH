package com.padcx.movieapp_hhh.viewHolders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.padcx.movieapp_hhh.data.vos.*

abstract class BaseViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    var mdata : ResultVO? = null
    var mMovieData : MovieDetailsVO? = null

    var mShowCaseData : ShowCaseVO? = null


    abstract fun bindData(data :ResultVO)
    abstract fun bindActorData(data : ActorVO)
    abstract fun bindShowCaseData(data : ShowCaseVO)
    abstract fun bindDiscoverData(data : DiscoverVO)
    abstract fun bindCastData(data : CastVO)
    abstract  fun bindCreatorData(data :CrewVO)
}