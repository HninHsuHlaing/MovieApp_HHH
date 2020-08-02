package com.padcx.movieapp_hhh.mvp.presenter

import com.padcx.movieapp_hhh.mvp.view.BaseView

interface BasePresenter <T: BaseView>{
    fun intiPresenter(view : T)
}