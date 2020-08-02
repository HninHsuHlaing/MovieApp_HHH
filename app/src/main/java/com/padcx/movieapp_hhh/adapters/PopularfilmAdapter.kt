package com.padcx.movieapp_hhh.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.padcx.movieapp_hhh.R
import com.padcx.movieapp_hhh.data.vos.ResultVO
import com.padcx.movieapp_hhh.delegate.DetailDelegate
//import com.padcx.movieapp_hhh.delegate.PopularMovieDelegate
import com.padcx.movieapp_hhh.viewHolders.PopularFilmViewHolder

class PopularfilmAdapter(private val mDelegate : DetailDelegate): RecyclerView.Adapter<PopularFilmViewHolder>() {

   // val mPopularMovieDelegate :PopularMovieDelegate = mDelegate
     var mData : List<ResultVO> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularFilmViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.best_movie_item,parent,false)
        return PopularFilmViewHolder(view,mDelegate)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: PopularFilmViewHolder, position: Int) {
        mData.get(position).let {
            holder.bindData(it)
        }
    }
    fun setNewsData(data : List<ResultVO>){
        mData = data
        notifyDataSetChanged()
    }
}