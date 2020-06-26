package com.yammobots.holidaytestapp.common

import androidx.recyclerview.widget.DiffUtil

/**
 * Created by kaungkhantsoe on 24/06/2020.
 */
abstract class BaseDiffUtil : DiffUtil.Callback() {

    // Variables to be implemented by child class as constructor
    abstract var mOldItemList: List<Pageable>?
    abstract var mNewItemList: List<Pageable>?

    // Function to be implemented by child class
    protected abstract fun areTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean

    override fun getOldListSize(): Int {
        return if (mOldItemList == null) 0 else mOldItemList!!.size
    }

    override fun getNewListSize(): Int {
        return if (mNewItemList == null) 0 else mNewItemList!!.size
    }

    override fun areItemsTheSame(
        oldItemPosition: Int,
        newItemPosition: Int
    ): Boolean {
        return areTheSame(oldItemPosition, newItemPosition)
    }

    override fun areContentsTheSame(
        oldItemPosition: Int,
        newItemPosition: Int
    ): Boolean {
        return if (mOldItemList != null && mNewItemList != null) mOldItemList!![oldItemPosition] == mNewItemList!![newItemPosition] else false
    }
}