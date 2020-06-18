package com.yammobots.holidaytestapp.network

import com.yammobots.holidaytestapp.model.PhotoModel
import io.reactivex.Flowable
import retrofit2.http.GET

/**
 * Created by kaungkhantsoe on 17/06/2020.
 **/

interface HomeApi {

    @GET("photos")
    fun getPhotos() : Flowable<ArrayList<PhotoModel>>
}