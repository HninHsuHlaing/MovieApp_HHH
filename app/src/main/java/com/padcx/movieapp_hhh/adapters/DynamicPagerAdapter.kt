package com.padcx.movieapp_hhh.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.padcx.movieapp_hhh.data.vos.GenerVO
import com.padcx.movieapp_hhh.fragment.ActionFragment

class DynamicPagerAdapter(fm:FragmentManager,val list:List<GenerVO>) : FragmentStatePagerAdapter(fm,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return ActionFragment.newInstance(list[position].id)
    }

    override fun getCount(): Int {

        return list.count()
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return list[position].name
    }
}