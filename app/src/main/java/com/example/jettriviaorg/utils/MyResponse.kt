package com.example.jettriviaorg.utils

data class MyResponse<out T>(val status: Status, val data: T? = null, val message: String? = null){

    enum class Status {
        SUCCESS,
        LOADING,
        ERROR
    }

    companion object {

        fun<T> loading(): MyResponse<T> {
            return MyResponse(Status.LOADING)
        }

        fun<T> success(data: T): MyResponse<T> {
            return MyResponse(Status.SUCCESS, data)
        }

        fun<T> error(message: String): MyResponse<T> {
            return MyResponse(Status.ERROR, message = message)
        }
    }
}

