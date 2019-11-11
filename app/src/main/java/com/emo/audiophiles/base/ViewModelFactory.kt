package com.emo.audiophiles.base

import android.util.ArrayMap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.emo.audiophiles.di.ViewModelSubComponent
import com.emo.audiophiles.ui.home.HomeViewModel
import java.util.concurrent.Callable
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class ViewModelFactory : ViewModelProvider.Factory {

    private val creators: ArrayMap<Class<*>, Callable<out ViewModel>> = ArrayMap()

    @Inject
    constructor(viewModelSubComponent: ViewModelSubComponent) {
        creators.put(
            HomeViewModel::class.java,
            Callable<ViewModel> { viewModelSubComponent.homeViewModel() })
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        var creator = creators[modelClass]
        if (creator == null) {
            for (entry in creators.entries) {
                if (modelClass.isAssignableFrom(entry.key)) {
                    creator = entry.value
                    break
                }
            }
        }
        requireNotNull(creator) { "Unknown model class $modelClass" }
        try {
            return creator.call() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }

    }

}