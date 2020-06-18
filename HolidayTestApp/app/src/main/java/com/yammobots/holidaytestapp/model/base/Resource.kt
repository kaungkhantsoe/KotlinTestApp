package com.yammobots.holidaytestapp.model.base

/**
 * Created by kaungkhantsoe on 17/06/2020.
 **/


class Resource<T>(status: Status, data: T, message: String) {
    val status: Status
    val data: T
    val message: String

    enum class Status {
        SUCCESS, ERROR, LOADING
    }

    companion object {
        fun <T> success(data: T): Resource<T> {
            return Resource(Status.SUCCESS, data, "")
        }

        fun <T> error(msg: String, data: T): Resource<T> {
            return Resource(Status.ERROR, data, msg)
        }

        fun <T> loading(data: T): Resource<T> {
            return Resource(Status.LOADING, data, "")
        }
    }

    init {
        this.status = status
        this.data = data
        this.message = message
    }
}
