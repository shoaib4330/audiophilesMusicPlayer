package com.emo.audiophiles.ui.home


import com.emo.audiophiles.R
import com.emo.audiophiles.base.BaseFragment

/**
 * Fragment to display as app home screen, when app is opened
 */
class HomeFragment : BaseFragment() {

    override fun getLayoutId(): Int = R.layout.fragment_home

    companion object {
        fun newInstance(): HomeFragment = HomeFragment()
    }

}
