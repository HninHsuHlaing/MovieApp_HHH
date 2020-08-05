package com.padcx.movieapp_hhh.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.padcx.movieapp_hhh.R
import com.padcx.movieapp_hhh.data.vos.ActorVO
import com.padcx.movieapp_hhh.data.vos.CastVO
import com.padcx.movieapp_hhh.delegate.DetailDelegate
import mk.padc.themovie.views.viewholders.CastViewHolder

class CastAdapter() : RecyclerView.Adapter<CastViewHolder>() {

    var mData : List<CastVO> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.best_actor_item,parent,false)

        return CastViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mData.count()
    }

    override fun onBindViewHolder(holder: CastViewHolder, position: Int) {
        mData.get(position).let { holder.bindCastData(it) }
    }
    fun setNewsData(data : List<CastVO>){
        mData = data
        notifyDataSetChanged()
    }
}