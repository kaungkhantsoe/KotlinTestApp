package com.yammobots.holidaytestapp.util

import com.yammobots.holidaytestapp.model.PhotoModel
import java.util.*

/**
 * Created by kaungkhantsoe on 19/06/2020.
 **/

object TestUtil {
    var PHOTO_MODEL = PhotoModel()
    const val TITLE_1 = "Title 1"
    const val TITLE_2 = "Title 2"
    const val URL_1 = "https://via.placeholder.com/600/8e973b"
    const val URL_2 = "https://via.placeholder.com/600/121fa4"
    val TEST_PHOTO_MODEL_1 = PhotoModel(1, 1, TITLE_1, URL_1, "")
    val TEST_PHOTO_MODEL_2 = PhotoModel(1, 2, TITLE_2, URL_2, "")
    val PHOTO_MODEL_LIST: List<PhotoModel> = Collections.unmodifiableList(mutableListOf(TEST_PHOTO_MODEL_1, TEST_PHOTO_MODEL_2))
}