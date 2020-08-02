package com.padcx.movieapp_hhh.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.padcx.movieapp_hhh.R
import com.padcx.movieapp_hhh.data.vos.ActorVO
import com.padcx.movieapp_hhh.viewHolders.ActorForDetailPageViewHolder

class ActorForDetailPageAdatpter: RecyclerView.Adapter<ActorForDetailPageViewHolder>() {
   // var mActorDelegate : ActorDelegate = delegate
   var mData : List<ActorVO> = mutableListOf()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ActorForDetailPageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.best_actor_item,parent,false)
        return ActorForDetailPageViewHolder(view)
    }

    override fun getItemCount(): Int {
       return mData.size
    }

    override fun onBindViewHolder(holder: ActorForDetailPageViewHolder, position: Int) {
        mData.get(position).let { holder.bindActorData(it) }
    }
    fun setNewsData(data : List<ActorVO>){
        mData = data
        notifyDataSetChanged()
    }
}