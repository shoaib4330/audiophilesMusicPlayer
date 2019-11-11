package com.emo.audiophiles.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.emo.audiophiles.R
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject

open class BaseFragmentActivity : BaseToolbarActivity() {

    @Inject
    lateinit var supportFragmentInjector: DispatchingAndroidInjector<Fragment>

    var fragment: BaseFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun getLayoutId() : Int = R.layout.activity_base_fragment


    override fun initViews(savedInstanceState: Bundle?) {
        super.initViews(savedInstanceState)
        val bundle = intent.extras
        if (bundle != null && bundle.containsKey(FRAGMENT_CLASS_NAME)) {
            fragment = Fragment.instantiate(this, bundle.getString(FRAGMENT_CLASS_NAME)) as BaseFragment?
            fragment?.arguments = bundle
            if (savedInstanceState == null) {
                addFragment(fragment!!, true, true)
            }
        }

        supportFragmentManager.addOnBackStackChangedListener {
            //todo: no onBackStackChange event actions listed in supportFragmentManager
        }
    }

    companion object {
        const val FRAGMENT_CLASS_NAME = "fragment_class_name"
    }

    override fun updateToolbarTitle(title: String) {
        super.updateToolbarTitle(title)
        setToolBarTitle(title)
    }

}