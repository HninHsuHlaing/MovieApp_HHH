//package com.padcx.movieapp_hhh.adapters
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.padcx.movieapp_hhh.R
//import com.padcx.movieapp_hhh.delegate.MovieDetailDelegate
//import com.padcx.movieapp_hhh.delegate.PopularMovieDelegate
//import com.padcx.movieapp_hhh.viewHolders.PopularFilmViewHolder
//
//class PagerRecyclerAdapter(private val delegate: MovieDetailDelegate) : RecyclerView.Adapter<PopularFilmViewHolder>() {
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularFilmViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.best_movie_item,parent,false)
//        return PopularFilmViewHolder(view,delegate)
//    }
//
//    override fun getItemCount(): Int {
//      return 10
//    }
//
//    override fun onBindViewHolder(holder: PopularFilmViewHolder, position: Int) {
//
//    }
//}