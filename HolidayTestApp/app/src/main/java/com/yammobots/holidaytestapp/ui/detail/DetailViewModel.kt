package com.yammobots.holidaytestapp.ui.detail

import androidx.lifecycle.ViewModel
import com.yammobots.holidaytestapp.model.PhotoModel
import javax.inject.Inject

/**
 * Created by kaungkhantsoe on 18/06/2020.
 **/

class DetailViewModel @Inject constructor() : ViewModel() {

    lateinit var photoModel: PhotoModel

}