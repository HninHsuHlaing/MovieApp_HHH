package com.padcx.movieapp_hhh.mvp.presenter

import android.view.View
import androidx.lifecycle.ViewModel
import com.padcx.movieapp_hhh.mvp.view.BaseView

abstract class AbstractBasePresenter<T : BaseView> :BasePresenter<T>, ViewModel() {
    var mView: T? = null

    override fun intiPresenter(view: T) {
        mView = view
    }
}