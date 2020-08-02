package com.padcx.movieapp_hhh.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.padcx.movieapp_hhh.R
import com.padcx.movieapp_hhh.data.vos.ResultVO
import com.padcx.movieapp_hhh.data.vos.ShowCaseVO
import com.padcx.movieapp_hhh.delegate.DetailDelegate
//import com.padcx.movieapp_hhh.delegate.ActorDelegate
import com.padcx.movieapp_hhh.viewHolders.ShowCaseViewHolder

class ShowCaseAdapter(private val mDelegate : DetailDelegate): RecyclerView.Adapter<ShowCaseViewHolder>() {
  //  var mActorDelegate : ActorDelegate = delegate
  var mData : List<ShowCaseVO> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowCaseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.show_case_item,parent,false)
        return  ShowCaseViewHolder(view,mDelegate)
    }

    override fun getItemCount(): Int {
       return mData.size
    }

    override fun onBindViewHolder(holder: ShowCaseViewHolder, position: Int) {
        mData.get(position).let { holder.bindShowCaseData(it) }

    }
    fun setNewsData(data : List<ShowCaseVO>){
        mData = data
        notifyDataSetChanged()
    }
}