package com.padcx.movieapp_hhh.viewHolders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.padcx.movieapp_hhh.data.vos.*
//import com.padcx.movieapp_hhh.delegate.PopularMovieDelegate
import com.padcx.movieapp_hhh.delegate.PopularMovieListDelegate
import com.padcx.movieapp_hhh.util.img_url_actor
import kotlinx.android.synthetic.main.best_movie_item.view.*

class ActionFragmentViewHolder(itemView : View, private val mDelegate: PopularMovieListDelegate) :AbstractDiscoverViewHolder(itemView) {


    init {
        itemView.ivBestMovie.setOnClickListener {
//            mData?.let {
//                mDelegate.onTapDiscoverListItem(it)
//            }
            mDiscoverData.let {
                if (it != null) {
                    mDelegate.onTapDiscoverListItem(it)
                }
            }
        }
    }

    override fun bindData(data: ResultVO) {

    }

    override fun bindActorData(data: ActorVO) {

    }

    override fun bindShowCaseData(data: ShowCaseVO) {

    }

    override fun bindDiscoverData(data: DiscoverVO) {
        mDiscoverData = data
        itemView.tvBestMovieName.text = mDiscoverData!!.original_title
        var imgurl = img_url_actor + mDiscoverData?.poster_path
        Glide
            .with(itemView.context)
            .load(imgurl)
            .into(itemView.ivBestMovie)
    }

    override fun bindCastData(data: CastVO) {

    }

    override fun bindCreatorData(data: CrewVO) {

    }


}