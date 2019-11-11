package com.emo.audiophiles.ui

import android.os.Bundle
import android.widget.Toast
import com.emo.audiophiles.base.BaseFragmentActivity
import com.emo.audiophiles.ui.home.HomeFragment

class DispatchActivity : BaseFragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // load the initial fragment
        addFragment(HomeFragment.newInstance(), clearBackStack = false, addToBackstack = false)
        Toast.makeText(this, "`DispatchActivity` created", Toast.LENGTH_SHORT).show()
    }
}
