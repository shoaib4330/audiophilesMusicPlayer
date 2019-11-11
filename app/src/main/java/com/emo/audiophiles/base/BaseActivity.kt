package com.emo.audiophiles.base

import android.app.Dialog
import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.emo.audiophiles.R
import java.util.*


abstract class BaseActivity : AppCompatActivity(), BaseFragment.FragmentNavigationHelper {

    private var currentFragment: BaseFragment? = null
    private val fragments = Stack<Fragment>()
    private var dialog: Dialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        val inflater = layoutInflater
        val contentView = inflater.inflate(getLayoutId(), null)
        setContentView(contentView)
        initViews(savedInstanceState)
    }

    open fun initViews(savedInstanceState: Bundle?) {

    }

    fun onFragmentBackStackChanged() {
        /*
        if some actions on required on this event, do them here
         */
    }

    abstract fun getLayoutId(): Int

    override fun addFragment(
        f: BaseFragment,
        layoutId: Int,
        clearBackStack: Boolean,
        addToBackstack: Boolean
    ) {
        if (clearBackStack)
            clearFragmentBackStack()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(layoutId, f)
        if (addToBackstack)
            transaction.addToBackStack(null)
        transaction.commitAllowingStateLoss()

        currentFragment = f
        fragments.push(f)

        onFragmentBackStackChanged()
    }

    override fun addFragment(f: BaseFragment, clearBackStack: Boolean, addToBackstack: Boolean) {
        addFragment(f, R.id.fragment_container, clearBackStack, addToBackstack)
    }

    override fun replaceFragment(
        f: BaseFragment,
        clearBackStack: Boolean,
        addToBackstack: Boolean
    ) {
        replaceFragment(f, R.id.fragment_container, clearBackStack, addToBackstack)
    }

    override fun replaceFragment(f: BaseFragment, layoutId: Int, clearBackStack: Boolean, addToBackstack: Boolean) {
        if (clearBackStack) {
            clearFragmentBackStack()
        }

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(layoutId, f)
        if (addToBackstack) {
            transaction.addToBackStack(null)
        }
        transaction.commitAllowingStateLoss()

        currentFragment = f
        fragments.push(f)

        onFragmentBackStackChanged()
    }

    override fun clearFragmentBackStack() {
        val fm = supportFragmentManager
        for (index in 0 until fm.backStackEntryCount) {
            fm.popBackStack()
        }

        if (!fragments.isEmpty()) {
            currentFragment = fragments[0] as BaseFragment
            val homeScreenFragment = fragments[0]
            fragments.clear()
            fragments.push(homeScreenFragment)
        }
    }

    override fun updateToolbarTitle(title: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showLoadingDialog() {
        dialog?.let {
            if(!it.isShowing)
                it.show()
        }
    }

    override fun hideLoadingDialog() {
        dialog?.let {
            if(it.isShowing)
                it.dismiss()
        }
    }

    override fun onBack() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getToolbarInstance(): Toolbar {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}