package com.emo.audiophiles.base

import androidx.appcompat.widget.Toolbar

abstract class BaseToolbarActivity : BaseActivity(){

    lateinit var toolbar: Toolbar

    fun setUpToolbar(toolbar: Toolbar) {
        this.toolbar = toolbar
    }

    override fun getToolbarInstance(): Toolbar {
        return toolbar
    }

    fun setToolBarTitle(title: String) {
        toolbar.setTitle(title)
    }

    fun setRightText(text: String, color: Int) {
    }

    fun setBackButtonVisibility(visibility: Int) {
//        when (visibility) {
//            View.VISIBLE ->
//                toolbar.showBackButton()
//            else ->
//                toolbar.hideBackButton()
//        }
    }
}