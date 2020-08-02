package com.padcx.movieapp_hhh.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.padcx.movieapp_hhh.R
import com.padcx.movieapp_hhh.data.vos.DiscoverVO
import com.padcx.movieapp_hhh.delegate.PopularMovieListDelegate
import com.padcx.movieapp_hhh.viewHolders.ActionFragmentViewHolder

class DiscoverAdapter (private val movieListDelegate: PopularMovieListDelegate) :
    RecyclerView.Adapter<ActionFragmentViewHolder>() {
    var mDiscoverData : List<DiscoverVO> = arrayListOf()
    override fun getItemCount(): Int {
            return  mDiscoverData.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActionFragmentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.best_movie_item,parent,false)
        return ActionFragmentViewHolder(view,movieListDelegate)
    }

    override fun onBindViewHolder(holder: ActionFragmentViewHolder, position: Int) {
        mDiscoverData.get(position).let {
            holder.bindDiscoverData(it)
        }

    }
    fun setNewsData(data : List<DiscoverVO>){
        mDiscoverData = data

    }
}