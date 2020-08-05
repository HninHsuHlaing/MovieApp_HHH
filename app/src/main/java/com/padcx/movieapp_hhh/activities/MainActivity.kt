package com.padcx.movieapp_hhh.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ViewFlipper
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.padcx.movieapp_hhh.R
import com.padcx.movieapp_hhh.adapters.ActorAdapter
import com.padcx.movieapp_hhh.adapters.DynamicPagerAdapter
import com.padcx.movieapp_hhh.adapters.PopularfilmAdapter
import com.padcx.movieapp_hhh.adapters.ShowCaseAdapter
import com.padcx.movieapp_hhh.data.models.MovieModel
import com.padcx.movieapp_hhh.data.models.MovieModelImpl
import com.padcx.movieapp_hhh.data.vos.ActorVO
import com.padcx.movieapp_hhh.data.vos.GenerVO
import com.padcx.movieapp_hhh.data.vos.ResultVO
import com.padcx.movieapp_hhh.data.vos.ShowCaseVO
import com.padcx.movieapp_hhh.mvp.presenter.MainPresenter
import com.padcx.movieapp_hhh.mvp.presenter.MainPresenterImpl
import com.padcx.movieapp_hhh.mvp.view.MainView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(),MainView {


    private val mMovieModel : MovieModel = MovieModelImpl
    private lateinit var mPresenter :MainPresenter
    var tablayout : TabLayout? = null
    var viewPager : ViewPager? = null
   // var viewflipper : ViewFlipper? = null

    lateinit var mPopularfilmAdapter: PopularfilmAdapter
    lateinit var mShowCaseAdapter: ShowCaseAdapter
    lateinit var mActorAdapter: ActorAdapter

    lateinit var mDynamicPagerAdapter : DynamicPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mPresenter = MainPresenterImpl()
           // viewflipper = findViewById(R.id.viewflipper)

        viewflipper.flipInterval = 3000
        viewflipper.isAutoStart = true

        btnPlayTester.setOnClickListener {
            startActivity(PlayVideoActivity.newInstant(this))
        }
        imgPlayTester.setOnClickListener {
            startActivity(PlayVideoActivity.newInstant(this))
        }
        imgPlayTester1.setOnClickListener {
            startActivity(PlayVideoActivity.newInstant(this))
        }
//        btnSchowCasePlay.setOnClickListener {
//            startActivity(PlayVideoActivity.newInstant((this)))
//        }


        setUpPresenter()
        mPresenter.onUiReady(this)
        mPresenter.onActorUiReady(this)
        mPresenter.onShowCaseUIReady(this)
        mPresenter.onShowGenerUIReady(this)

        btnPlayTester.setOnClickListener {
            startActivity(PlayVideoActivity.newInstant(this))
        }

        setUpRecycler()
//        igLocation.setOnClickListener {
//            startActivity(MovieDetail.newIntent(this))
//        }


    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(MainPresenterImpl::class.java)
       // mPresenter = MainPresenterImpl()
        mPresenter.intiPresenter(this)
    }

//    private fun setUpPresenter() {
//        mPresenter = ViewModelProviders.of(this).get(MainPresenterImpl::class.java)
//
//    }

    private fun setUpRecycler() {
        mPopularfilmAdapter = PopularfilmAdapter(mPresenter)
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rcBestMovie.layoutManager = linearLayoutManager
        rcBestMovie.adapter = mPopularfilmAdapter



        mShowCaseAdapter = ShowCaseAdapter(mPresenter)
        val linearLayoutManager2 = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rcShowCase.layoutManager = linearLayoutManager2
        rcShowCase.adapter = mShowCaseAdapter


        mActorAdapter = ActorAdapter()
        val linearLayoutManager3 = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rcActorList.layoutManager = linearLayoutManager3


    }

//    public fun showGerne(list: List<String>){
//        mDynamicPagerAdapter = DynamicPagerAdapter(supportFragmentManager,list)
//        pager.adapter = mDynamicPagerAdapter
//        tabs.setupWithViewPager(pager)
//    }

    override fun displayPopularMovieList(list: List<ResultVO>) {
        mPopularfilmAdapter.setNewsData(list)
    }

    override fun displayShowcaseeMovieList(list: List<ShowCaseVO>) {
        mShowCaseAdapter.setNewsData(list)
    }





    override fun displayActorList(list: List<ActorVO>) {
        mActorAdapter.setNewsData(list)
        rcActorList.adapter = mActorAdapter
    }



    override fun navigateToactorDetail(movie_id : Int) {
            startActivity(MovieDetail.newIntent(this,movie_id))
    }

    override fun showGenerList(list: List<GenerVO>) {
        mDynamicPagerAdapter = DynamicPagerAdapter(supportFragmentManager,list)
        pager.adapter = mDynamicPagerAdapter
        tabs.setupWithViewPager(pager)
    }
}
