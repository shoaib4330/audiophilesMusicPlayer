package com.emo.audiophiles.di

import com.emo.audiophiles.AudioPhilesApplication
import com.emo.audiophiles.di.builder.ActivityBuilder
import com.emo.audiophiles.di.provision.ApplicationModule
import com.emo.audiophiles.di.provision.RemoteModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule


@Component(modules = [AndroidSupportInjectionModule::class, ApplicationModule::class, ActivityBuilder::class, RemoteModule::class])
interface ApplicationComponent : AndroidInjector<AudioPhilesApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<AudioPhilesApplication>(){
        abstract override fun build(): ApplicationComponent
    }
}