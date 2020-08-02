package com.padcx.movieapp_hhh.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.padcx.movieapp_hhh.R
import com.padcx.movieapp_hhh.data.vos.ActorVO
import com.padcx.movieapp_hhh.data.vos.DiscoverVO
import com.padcx.movieapp_hhh.delegate.PopularMovieListDelegate
import com.padcx.movieapp_hhh.viewHolders.ActionFragmentViewHolder

class ActionFragmentAdapter(private val mDelegate: PopularMovieListDelegate) : RecyclerView.Adapter<ActionFragmentViewHolder>() {

    var mActionDelegate: PopularMovieListDelegate = mDelegate
    var mData: List<DiscoverVO> = arrayListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActionFragmentViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.best_movie_item, parent, false)
        return ActionFragmentViewHolder(view, mActionDelegate)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: ActionFragmentViewHolder, position: Int) {
        mData.get(position).let {
            holder.bindDiscoverData(it)
        }
    }
    fun setNewsData(data : List<DiscoverVO>){
        mData = data
        notifyDataSetChanged()
    }
}