package com.padcx.movieapp_hhh.mvp.view

import com.padcx.movieapp_hhh.data.vos.DiscoverVO


interface MovieView : BaseView {

    fun displayMovieList(list: List<DiscoverVO>)
}