package com.padcx.movieapp_hhh.viewHolders

import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.padcx.movieapp_hhh.data.vos.ActorVO
import com.padcx.movieapp_hhh.data.vos.DiscoverVO
import com.padcx.movieapp_hhh.data.vos.ResultVO
import com.padcx.movieapp_hhh.data.vos.ShowCaseVO
import com.padcx.movieapp_hhh.delegate.DetailDelegate
//import com.padcx.movieapp_hhh.delegate.PopularMovieDelegate
import com.padcx.movieapp_hhh.util.image_url
import kotlinx.android.synthetic.main.best_movie_item.view.*

class PopularFilmViewHolder(itemView : View, private val mDelegate : DetailDelegate) : AbstractPopularFilmViewHolder(itemView) {
    init {
        itemView.ivBestMovie.setOnClickListener {
//            mMovieData.let {
//              //  it?.let { it1 -> delegate.onTapPopularMovieItem(it1) }
//             //   Log.d("tag","Tap the movie item")

            mdata?.let {
                mDelegate.onTapMovieITem(mdata!!.id)
            }
        }
    }
 override fun bindData(data: ResultVO) {
    mdata = data
   itemView.tvBestMovieName.text = mdata?.original_title
     var imgurl = image_url+ mdata?.poster_path
     Glide
         .with(itemView.context)
         .load(imgurl)
         .into(itemView.ivBestMovie)

 }

    override fun bindActorData(data: ActorVO) {

    }

    override fun bindShowCaseData(data: ShowCaseVO) {
        
    }

    override fun bindDiscoverData(data: DiscoverVO) {

    }


}