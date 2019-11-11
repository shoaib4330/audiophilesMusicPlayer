package com.emo.audiophiles.Repository.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.emo.audiophiles.model.Track

class TracksRepository constructor() {

    fun getTracksByQuery(query: String): LiveData<List<Track>> {
        val data: LiveData<List<Track>> = MutableLiveData()
        return data
    }
}