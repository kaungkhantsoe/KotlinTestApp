package com.yammobots.holidaytestapp.repository.main.home

import com.yammobots.holidaytestapp.model.PhotoModel
import com.yammobots.holidaytestapp.model.base.Resource
import com.yammobots.holidaytestapp.network.HomeApi
import com.yammobots.holidaytestapp.util.AppConstants.CONNECTION_OR_SERVER_ERROR
import io.reactivex.Flowable
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by kaungkhantsoe on 17/06/2020.
 **/

class HomeRepository @Inject constructor(private val homeApi: HomeApi){

    companion object {
        val ALBUM_ID_CANNOT_BE_ZERO_ERROR = "Album id must be greater than zero"
    }

    fun getPhotos(albumId: Int, list: ArrayList<PhotoModel>) : Flowable<Resource<ArrayList<PhotoModel>>> {

        checkId(albumId)

        if (homeApi.getPhotos(albumId) == null)
            return Flowable.just(Resource.error(CONNECTION_OR_SERVER_ERROR, ArrayList<PhotoModel>()))

        return  homeApi.getPhotos(albumId)!!
            .onErrorReturn(Function {
                val dummyList = ArrayList<PhotoModel>()
                val photoModel = PhotoModel()
                photoModel.id = -1
                return@Function dummyList
            })

            .map { photoModels: ArrayList<PhotoModel> ->
                if (photoModels[0].id == -1)
                    return@map Resource.error(CONNECTION_OR_SERVER_ERROR, ArrayList<PhotoModel>())

                if (list.size > 0) {
                    list.addAll(photoModels)
                    return@map Resource.success(list)
                }

                return@map Resource.success(photoModels)
            }

            .subscribeOn(Schedulers.io())
    }

    @Throws(Exception::class)
    private fun checkId(albumId: Int) {
        if (albumId <= 0)
            throw Exception(ALBUM_ID_CANNOT_BE_ZERO_ERROR)
    }

}