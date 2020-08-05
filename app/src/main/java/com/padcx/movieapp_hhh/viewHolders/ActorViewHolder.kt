package com.padcx.movieapp_hhh.viewHolders

import android.view.View
import com.bumptech.glide.Glide
import com.padcx.movieapp_hhh.data.vos.*
//import com.padcx.movieapp_hhh.delegate.ActorDelegate
import com.padcx.movieapp_hhh.util.img_url_actor
import kotlinx.android.synthetic.main.best_actor_item.view.*
import kotlinx.android.synthetic.main.best_movie_item.view.*

class ActorViewHolder(itemView : View) : AbstractActorViewHolder(itemView) {

    override fun bindData(data: ResultVO) {

    }

    override fun bindDiscoverData(data: DiscoverVO) {

    }

    override fun bindCastData(data: CastVO) {

    }

    override fun bindCreatorData(data: CrewVO) {

    }

    override fun bindActorData(data: ActorVO) {
        mActorData = data
//        var i = 0
//        var count =data.known_for.size
//        while (i<count){
//            itemView.tvActorName.text= data.known_for[i].name
//        }

        itemView.tvActorName.text = mActorData?.name
        var imgurl = img_url_actor+ mActorData?.profilePath
        Glide
            .with(itemView.context)
            .load(imgurl)
            .into(itemView.igActor)
    }

    override fun bindShowCaseData(data: ShowCaseVO) {


    }
}