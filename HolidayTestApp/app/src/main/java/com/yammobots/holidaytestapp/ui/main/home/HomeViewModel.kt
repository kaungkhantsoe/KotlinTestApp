package com.yammobots.holidaytestapp.ui.main.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.yammobots.holidaytestapp.model.PhotoModel
import com.yammobots.holidaytestapp.model.base.Resource
import com.yammobots.holidaytestapp.repository.main.home.HomeRepository
import javax.inject.Inject

/**
 * Created by kaungkhantsoe on 13/06/2020.
 **/

class HomeViewModel @Inject constructor(val homeRepository: HomeRepository) : ViewModel() {

    var albumId: Int = 0
    lateinit var mediatorLiveData: MediatorLiveData<Resource<ArrayList<PhotoModel>>>

    fun observePhotos() : MediatorLiveData<Resource<ArrayList<PhotoModel>>> {

        mediatorLiveData = MediatorLiveData()
        mediatorLiveData.value = Resource.loading(ArrayList())

        val source = LiveDataReactiveStreams.fromPublisher(
            this.homeRepository.getPhotos(albumId)
        )


        mediatorLiveData.addSource(source, Observer { resource ->
            mediatorLiveData.value = resource
            mediatorLiveData.removeSource(source)
        })

        return mediatorLiveData

    }

}