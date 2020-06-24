package com.yammobots.holidaytestapp.ui.main.home

import com.yammobots.holidaytestapp.common.BaseDiffUtil
import com.yammobots.holidaytestapp.common.Pageable
import com.yammobots.holidaytestapp.model.PhotoModel

/**
 * Created by kaungkhantsoe on 24/06/2020.
 **/

class HomeDiffUtil(
    override var mOldItemList: List<Pageable>?,
    override var mNewItemList: List<Pageable>?
) : BaseDiffUtil() {

    override fun areTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return if (mOldItemList != null && mNewItemList != null)
            (mOldItemList!![oldItemPosition] as PhotoModel).id == (mNewItemList!![newItemPosition] as PhotoModel).id
        else false
    }
}
