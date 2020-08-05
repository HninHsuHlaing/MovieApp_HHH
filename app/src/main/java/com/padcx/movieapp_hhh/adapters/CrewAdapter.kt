package com.padcx.movieapp_hhh.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.padcx.movieapp_hhh.R
import com.padcx.movieapp_hhh.data.vos.ActorVO
import com.padcx.movieapp_hhh.data.vos.CastVO
import com.padcx.movieapp_hhh.data.vos.CrewVO
import com.padcx.movieapp_hhh.delegate.DetailDelegate
import mk.padc.themovie.views.viewholders.CastViewHolder
import mk.padc.themovie.views.viewholders.CrewViewHolder

class CrewAdapter() : RecyclerView.Adapter<CrewViewHolder>() {

    var mData : List<CrewVO> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrewViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.best_actor_item,parent,false)

        return CrewViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mData.count()
    }

    override fun onBindViewHolder(holder: CrewViewHolder, position: Int) {
        mData.get(position).let { holder.bindCreatorData(it) }
    }
    fun setNewsData(data : List<CrewVO>){
        mData = data
        notifyDataSetChanged()
    }
}