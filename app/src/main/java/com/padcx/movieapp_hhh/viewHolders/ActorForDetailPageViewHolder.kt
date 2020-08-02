package com.padcx.movieapp_hhh.viewHolders

import android.view.View
import com.bumptech.glide.Glide
import com.padcx.movieapp_hhh.data.vos.ActorVO
import com.padcx.movieapp_hhh.data.vos.DiscoverVO
import com.padcx.movieapp_hhh.data.vos.ResultVO
import com.padcx.movieapp_hhh.data.vos.ShowCaseVO
import com.padcx.movieapp_hhh.util.img_url_actor
import kotlinx.android.synthetic.main.best_actor_item.view.*


class ActorForDetailPageViewHolder(itemView : View) : AbstractActorForDetailPageViewHolder(itemView) {
    override fun bindData(data: ResultVO) {

    }

    override fun bindActorData(data: ActorVO) {
        mActorData = data
//        var i = 0
//        var count =data.known_for.size
//        while (i<count){
//            itemView.tvActorName.text= data.known_for[i].name
//        }

        itemView.tvActorName.text = mActorData?.name
        var imgurl = img_url_actor + mActorData?.profilePath
        Glide
            .with(itemView.context)
            .load(imgurl)
            .into(itemView.igActor)
    }

    override fun bindShowCaseData(data: ShowCaseVO) {

    }

    override fun bindDiscoverData(data: DiscoverVO) {

    }


}