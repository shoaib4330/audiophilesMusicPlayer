package com.emo.audiophiles.di.provision

import android.app.Application
import android.content.Context
import com.emo.audiophiles.AudioPhilesApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule {


    @Provides
    @Singleton
    fun provideApplicationContext(application: AudioPhilesApplication): Context =
        application.applicationContext

    @Provides
    @Singleton
    fun provideApplication(application: AudioPhilesApplication): Application {
        return application
    }

}