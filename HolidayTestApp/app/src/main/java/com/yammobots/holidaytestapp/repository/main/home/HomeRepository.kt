package com.yammobots.holidaytestapp.repository.main.home

import android.util.Log
import com.yammobots.holidaytestapp.model.PhotoModel
import com.yammobots.holidaytestapp.model.base.Resource
import com.yammobots.holidaytestapp.network.HomeApi
import com.yammobots.holidaytestapp.repository.BaseRepository
import io.reactivex.Flowable
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by kaungkhantsoe on 17/06/2020.
 **/

class HomeRepository @Inject constructor(val homeApi: HomeApi) : BaseRepository() {

    fun getPhotos() : Flowable<Resource<ArrayList<PhotoModel>>> {
        return homeApi.getPhotos()
            .onErrorReturn { t : Throwable ->

                errorMessage = t.localizedMessage

                var dummyList = ArrayList<PhotoModel>()
                var photoModel = PhotoModel()
                photoModel.id = -1
                return@onErrorReturn dummyList

            }

            .map { photoModels: ArrayList<PhotoModel> ->
                if (photoModels[0].id == -1)
                    return@map Resource.error(errorMessage, ArrayList<PhotoModel>())


                return@map Resource.success(photoModels)
            }

            .subscribeOn(Schedulers.io())
    }

}