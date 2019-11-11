package com.emo.audiophiles.di

import com.emo.audiophiles.ui.home.HomeViewModel
import dagger.Subcomponent


@Subcomponent
interface ViewModelSubComponent {

    @Subcomponent.Builder
    interface Builder {
        fun build(): ViewModelSubComponent
    }

    fun homeViewModel(): HomeViewModel
}