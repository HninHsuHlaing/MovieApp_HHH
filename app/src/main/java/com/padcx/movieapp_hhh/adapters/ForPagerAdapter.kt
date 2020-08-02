package com.padcx.movieapp_hhh.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import com.padcx.movieapp_hhh.fragment.*

class ForPagerAdapter(fm: FragmentManager) :FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return  when(position){
            0->{
                ActionFragment()
            }
            1->{
                Advanturefragment()
            }2->{
                CriminalFragment()
            }3->{
                DramaFragment()
            }4->{
                ComidyFragment()
            }
            else->{
                ActionFragment()
            }
        }
    }

    override fun getCount(): Int {
       return  5
    }
}