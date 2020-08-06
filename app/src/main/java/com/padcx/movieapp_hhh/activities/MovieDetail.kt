package com.padcx.movieapp_hhh.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.padcx.movieapp_hhh.R
import com.padcx.movieapp_hhh.adapters.ActorForDetailPageAdatpter
import com.padcx.movieapp_hhh.adapters.CastAdapter
import com.padcx.movieapp_hhh.adapters.CreatorAdapter
import com.padcx.movieapp_hhh.adapters.CrewAdapter
import com.padcx.movieapp_hhh.data.models.MovieModel
import com.padcx.movieapp_hhh.data.models.MovieModelImpl
import com.padcx.movieapp_hhh.data.vos.*
import com.padcx.movieapp_hhh.mvp.presenter.MainPresenter
import com.padcx.movieapp_hhh.mvp.presenter.MovieDetailPresenter
import com.padcx.movieapp_hhh.mvp.presenter.MovieDetailPresenterImpl
import com.padcx.movieapp_hhh.mvp.view.MovieDetailView
import com.padcx.movieapp_hhh.util.image_url
import com.padcx.movieapp_hhh.util.img_url_actor
import com.padcx.movieapp_hhh.viewHolders.ActorForDetailPageViewHolder
import kotlinx.android.synthetic.main.best_movie_item.*
import kotlinx.android.synthetic.main.movie_detail_activity.*

class MovieDetail : AppCompatActivity(),  MovieDetailView{


    companion object{
        const val movieid = "Movie Id Extra"
        fun newIntent(context: Context, movie_id : Int): Intent {

            val intent = Intent(context,MovieDetail::class.java)
            intent.putExtra(movieid, movie_id)
            return intent
        }
    }
    lateinit var mActorForDetailPageAdatpter: ActorForDetailPageAdatpter
    lateinit var mCreatorAdapter: CreatorAdapter
    lateinit var  mcastAdapter: CastAdapter
    lateinit var mCrewAdapter  : CrewAdapter
    private lateinit var mPresenter : MovieDetailPresenter

    private  var  mMovieModel : MovieModel = MovieModelImpl


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_detail_activity)



        mPresenter = MovieDetailPresenterImpl()

        setUpPresenter()
        //mPresenter.onUiReady(this)
    //    mPresenter.onCreatorUiReady(this)
        val movie_id = intent.getIntExtra(movieid, 0)
//        mMovieModel.getMovieDetailById(movie_id)
//            .observe(this, Observer {
//                bindDetailData(it)
//            })
        mPresenter.onDetailUiReady(this,movie_id)
        mPresenter.onSchowCaseUIDetailReady(this,movie_id)
        setUpRecycler()
    }

    private fun setUpPresenter() {
        mPresenter= ViewModelProviders.of(this).get(MovieDetailPresenterImpl::class.java)
        mPresenter.intiPresenter(this)
    }

    private fun setUpRecycler() {
        mcastAdapter = CastAdapter()
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rcActorListForDetailPage.layoutManager = linearLayoutManager
        rcActorListForDetailPage.adapter = mcastAdapter

        mCrewAdapter = CrewAdapter()
        val linearLayoutManager1 = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rcCreatorList.layoutManager = linearLayoutManager1
        rcCreatorList.adapter = mCrewAdapter
    }



    override fun displayActorListDetail(list: List<CastVO>) {
       // mcastAdapter.setNewsData(list)
      //  rcActorListForDetailPage.adapter = mActorForDetailPageAdatpter
    }

    override fun displayCreatorList(list: List<CrewVO>) {
      // mCrewAdapter.setNewsData(list)
       // rcCreatorList.adapter = mActorForDetailPageAdatpter
    }

    override fun displayMovieDetail(moviedetail: MovieDetailsVO) {
        var imgurl = image_url + moviedetail.poster_path
        Glide
            .with(this)
            .load(imgurl)
            .into(movie_poster_image)
        movietitle?.text = moviedetail.original_title
        overview?.text = moviedetail.overview
        tvoriginalTitle.text = moviedetail.original_title
        tvType.text ="Advanture"
        tvProduction.text = moviedetail.tagline
        tvVoteCount.text = moviedetail.vote_count.toString()
        tvDescription.text = moviedetail.overview
        tvPremire.text = moviedetail.release_date



    }

    override fun displayCastCrewList(list: CastCrewVO) {
        mCrewAdapter.setNewsData(list.crew)
        rcCreatorList.adapter = mCrewAdapter


        mcastAdapter.setNewsData(list.cast)
        rcActorListForDetailPage.adapter = mcastAdapter

    }

    private fun bindDetailData(moviedetail : MovieDetailsVO){
        var imgurl = image_url + moviedetail.poster_path
        Glide
            .with(this)
            .load(imgurl)
            .into(movie_poster_image)
        movietitle?.text = moviedetail.original_title
        overview?.text = moviedetail.overview
    }


}
