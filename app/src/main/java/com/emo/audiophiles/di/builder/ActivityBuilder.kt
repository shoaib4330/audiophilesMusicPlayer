package com.emo.audiophiles.di.builder

import com.emo.audiophiles.ui.DispatchActivity
import com.emo.audiophiles.di.annotations.ActivityScope
import com.emo.audiophiles.ui.home.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuilder{
    @ActivityScope
    @ContributesAndroidInjector
    abstract fun contributeDispatchActivity() : DispatchActivity

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun contributePlaybackSessionFragment() : HomeFragment
}