package com.emo.audiophiles

import com.emo.audiophiles.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class AudioPhilesApplication : DaggerApplication(){

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.builder().create(this)
    }

    companion object{
        private lateinit var instance: AudioPhilesApplication
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}