package com.padcx.movieapp_hhh.viewHolders

import android.view.View
import com.bumptech.glide.Glide
import com.padcx.movieapp_hhh.data.vos.*
import com.padcx.movieapp_hhh.delegate.DetailDelegate
//import com.padcx.movieapp_hhh.delegate.ActorDelegate
import com.padcx.movieapp_hhh.util.image_url
import com.padcx.movieapp_hhh.util.img_url_shoecase
import kotlinx.android.synthetic.main.show_case_item.view.*

class ShowCaseViewHolder(itemView : View,private val mDelegate : DetailDelegate)  : AbstractShowCaseViewHolder(itemView) {

    init {
        itemView.igShowCase.setOnClickListener {
            mShowCaseData?.let {
                mDelegate.onTapShowCaseItem(it.id)
            }
        }
    }

    override fun bindData(data: ResultVO) {


    }

    override fun bindActorData(data: ActorVO) {

    }

    override fun bindShowCaseData(data: ShowCaseVO) {
       mShowCaseData= data
        itemView.tvRatingText.text = mShowCaseData?.releaseDate
        itemView.tvShcowCaseName.text = mShowCaseData?.title
        var imgurl = img_url_shoecase+ mShowCaseData?.poster_path
        Glide
            .with(itemView.context)
            .load(imgurl)
            .into(itemView.igShowCase)
    }

    override fun bindDiscoverData(data: DiscoverVO) {

    }

    override fun bindCastData(data: CastVO) {

    }

    override fun bindCreatorData(data: CrewVO) {

    }
}