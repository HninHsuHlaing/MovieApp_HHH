package com.padcx.movieapp_hhh.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.padcx.movieapp_hhh.R
import com.padcx.movieapp_hhh.data.vos.ActorVO
import com.padcx.movieapp_hhh.data.vos.ResultVO
//import com.padcx.movieapp_hhh.delegate.ActorDelegate
import com.padcx.movieapp_hhh.viewHolders.ActorViewHolder

class ActorAdapterForFragment : RecyclerView.Adapter<ActorViewHolder>() {
   // var mActorDelegate : ActorDelegate = delegate
    var mData : List<ActorVO> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.best_actor_item,parent,false)
        return  ActorViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: ActorViewHolder, position: Int) {
       // mData.get(position).let { holder.bindActorData(it) }
    }
    fun setNewsData(data : List<ActorVO>){
        mData = data
        notifyDataSetChanged()
    }
}