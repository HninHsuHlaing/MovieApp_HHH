package com.padcx.movieapp_hhh.delegate

import com.padcx.movieapp_hhh.data.vos.DiscoverVO
import com.padcx.movieapp_hhh.data.vos.TopRateMovieVO

interface PopularMovieListDelegate {

    fun onTapDiscoverListItem(entity : DiscoverVO)
  //  fun onTapShowCaseItem(entity : TopRateMovieVO)
}