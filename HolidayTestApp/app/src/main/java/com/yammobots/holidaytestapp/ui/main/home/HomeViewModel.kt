package com.yammobots.holidaytestapp.ui.main.home

import android.util.Log
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.yammobots.holidaytestapp.model.PhotoModel
import com.yammobots.holidaytestapp.model.base.Resource
import com.yammobots.holidaytestapp.repository.main.home.HomeRepository
import javax.inject.Inject

/**
 * Created by kaungkhantsoe on 13/06/2020.
 **/

class HomeViewModel @Inject constructor(val homeRepository: HomeRepository) : ViewModel() {

    private val TAG = "HomeViewModel"

    var albumId: Int = 0
    private lateinit var mediatorLiveData: MediatorLiveData<Resource<ArrayList<PhotoModel>>>
    private lateinit var photoList :ArrayList<PhotoModel> // For pagination

    fun observePhotos(): MediatorLiveData<Resource<ArrayList<PhotoModel>>> {

        if (albumId == 1) {
            photoList = ArrayList()
            mediatorLiveData = MediatorLiveData()
        }

        mediatorLiveData.value = Resource.loading(ArrayList())

        val source = LiveDataReactiveStreams.fromPublisher(
            this.homeRepository.getPhotos(albumId,photoList)
        )

        mediatorLiveData.addSource(source) { resource ->

            photoList = resource.data
            mediatorLiveData.value = resource
            mediatorLiveData.removeSource(source)

            Log.e(TAG, "observePhotos: livedata " + mediatorLiveData.value!!.data.size  )
            Log.e(TAG, "observePhotos: list " + photoList.size )

        }

        return mediatorLiveData
    }

}