package com.padcx.movieapp_hhh.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.padcx.movieapp_hhh.R
import com.padcx.movieapp_hhh.data.vos.TopRateMovieVO
import com.padcx.movieapp_hhh.util.img_url_actor



class SliderPagerAdapter(mContext: Context, mList: List<TopRateMovieVO>) :
    PagerAdapter() {
    private val mContext: Context
    private val mList: List<TopRateMovieVO>

    @NonNull
    override fun instantiateItem(@NonNull container: ViewGroup, position: Int): Any {
        val inflater = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val slideLayout: View = inflater.inflate(R.layout.slide_item, null)
        val slideImg: ImageView = slideLayout.findViewById(R.id.slide_img)
        val slideText: TextView = slideLayout.findViewById(R.id.slide_title)
//        val playimage: ImageView = slideLayout.findViewById(R.id.playimage)

        if(mList.size>0) {
         //   playimage.setImageResource(R.drawable.play)
            Glide
                .with(slideImg.context)
                .load(("$img_url_actor${mList[position].poster_path}"))
                .apply(RequestOptions.placeholderOf(R.drawable.place_holder_movie_maniac))
                .into(slideImg)
            slideText.setText(mList[position].title)
        }
        container.addView(slideLayout)
        return slideLayout
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
       return view === `object`
    }

    override fun getCount(): Int {
        return 4
    }



    override fun destroyItem(
        @NonNull container: ViewGroup,
        position: Int,
        @NonNull `object`: Any
    ) {
        container.removeView(`object` as View)
    }

    init {
        this.mContext = mContext
        this.mList = mList
    }
}