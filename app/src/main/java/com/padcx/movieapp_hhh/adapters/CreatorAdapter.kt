package com.padcx.movieapp_hhh.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.padcx.movieapp_hhh.R
///mport com.padcx.movieapp_hhh.delegate.ActorDelegate
import com.padcx.movieapp_hhh.viewHolders.CreatorViewHolder

class CreatorAdapter : RecyclerView.Adapter<CreatorViewHolder>() {
   // var mActorDelegate :ActorDelegate = delegate
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreatorViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.best_actor_item,parent,false)
        return CreatorViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: CreatorViewHolder, position: Int) {

    }
}