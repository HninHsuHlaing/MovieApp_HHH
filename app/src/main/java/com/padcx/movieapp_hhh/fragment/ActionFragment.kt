package com.padcx.movieapp_hhh.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.padcx.movieapp_hhh.R
import com.padcx.movieapp_hhh.adapters.DiscoverAdapter
import com.padcx.movieapp_hhh.data.vos.DiscoverVO
import com.padcx.movieapp_hhh.mvp.presenter.DiscoverPresenterImpl
import com.padcx.movieapp_hhh.mvp.presenter.DiscoverPrsenter
import com.padcx.movieapp_hhh.mvp.view.MovieView
import kotlinx.android.synthetic.main.action_fragment.*


private const val ARG_PARAM1 = "movie_id"
class ActionFragment : Fragment(),MovieView {
    private var movie_id: Int? = null
   // private lateinit var mAdapter: ActionFragmentAdapter
    private lateinit var mAdapter : DiscoverAdapter
    private lateinit var mPresenter: DiscoverPrsenter



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            movie_id = it.getInt(ARG_PARAM1)
            Log.d("MovieId",movie_id.toString())
        }
    }

    private fun setUpRecyclerView() {
        mAdapter = DiscoverAdapter(mPresenter)
        val alinearLayoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        rcActionFragment.layoutManager = alinearLayoutManager
        rcActionFragment.adapter = mAdapter
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(DiscoverPresenterImpl::class.java)
        mPresenter.intiPresenter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.action_fragment, container, false)
        super.onCreate(savedInstanceState)
        arguments?.let {
            movie_id = it.getInt(ARG_PARAM1)
            Log.d("MovieId",movie_id.toString())
        }
        setUpPresenter()
         mPresenter.onDiscoverUiReady(this,movie_id.toString())


       // movie_id?.let { mPresenter.onDiscoverReady(it) }

        return  view

    }



//    companion object{
//        fun newInstance(id:Int):ActionFragment{
//            val fragment = ActionFragment().apply {
//                arguments = Bundle().apply {
//                    putInt(ARG_PARAM1, id)
//                }
//            }
//            //need to put bundle
//
//            return fragment
//        }
//    }
    companion object{
    @JvmStatic
    fun newInstance(movie_id: Int) =
        ActionFragment().apply {
            arguments = Bundle().apply {
                putInt(ARG_PARAM1, movie_id)
            }
        }
}

    override fun displayMovieList(list: List<DiscoverVO>) {
        mAdapter.setNewsData(list)
        mAdapter.notifyDataSetChanged()
    }
}