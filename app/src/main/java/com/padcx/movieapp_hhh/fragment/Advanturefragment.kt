package com.padcx.movieapp_hhh.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.padcx.movieapp_hhh.R
import com.padcx.movieapp_hhh.adapters.ActorAdapter
import com.padcx.movieapp_hhh.adapters.ActorAdapterForFragment
import com.padcx.movieapp_hhh.mvp.presenter.MainPresenter
import com.padcx.movieapp_hhh.mvp.presenter.MainPresenterImpl
import kotlinx.android.synthetic.main.action_fragment.*
import kotlinx.android.synthetic.main.advanture_fragment.*

class Advanturefragment : Fragment() {
    private lateinit var  mAdapter : ActorAdapterForFragment
    private  var mPresenter : MainPresenter = MainPresenterImpl()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.advanture_fragment,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mAdapter = ActorAdapterForFragment()
        val layoutManager1 = LinearLayoutManager(activity)
        layoutManager1.orientation = LinearLayoutManager.HORIZONTAL
        rcAdvantureFragment.layoutManager = layoutManager1
        rcAdvantureFragment.adapter = mAdapter
    }
}