package com.yammobots.holidaytestapp.model

import com.yammobots.holidaytestapp.common.Pageable
import java.io.Serializable

/**
 * Created by kaungkhantsoe on 17/06/2020.
 **/

class PhotoModel : Serializable,Pageable{

    var albumId : Int = 0
    var id : Int = 0
    var title : String = ""
    var url : String = ""
    var thumbnailUrl : String = ""
}