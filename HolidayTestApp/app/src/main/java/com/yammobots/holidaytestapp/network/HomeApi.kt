package com.yammobots.holidaytestapp.network

import com.yammobots.holidaytestapp.model.PhotoModel
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by kaungkhantsoe on 17/06/2020.
 **/

interface HomeApi {

    @GET("photos")
    fun getPhotos(@Query("albumId") albumId: Int) : Flowable<ArrayList<PhotoModel>>?
}