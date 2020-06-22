package com.yammobots.holidaytestapp.model

import androidx.room.Ignore
import com.yammobots.holidaytestapp.common.Pageable
import java.io.Serializable

/**
 * Created by kaungkhantsoe on 17/06/2020.
 **/

class PhotoModel() : Serializable,Pageable{

    var albumId : Int = 0
    var id : Int = 0
    var title : String = ""
    var url : String = ""
    var thumbnailUrl : String = ""

    @Ignore
    constructor(albumId: Int, id: Int, title: String, url: String, thumbnailUrl: String) : this() {
        this.albumId = albumId
        this.id = id
        this.title = title
        this.url = url
        this.thumbnailUrl = thumbnailUrl
    }

    override fun equals(obj: Any?): Boolean {
        if (obj == null) {
            return false
        }
        if (javaClass != obj.javaClass) {
            return false
        }
        val photoModel: PhotoModel =
            obj as PhotoModel
        return photoModel.id == id
    }
}