package com.example.getyourmovie.repository

enum class Status {
    RUNNING,
    SUCCESS,
    FAILED
}
class NetworkState(val status: Status, val msg: String) {

    companion object{
        val LOADED: NetworkState
        val LOADING: NetworkState
        val ERROR: NetworkState

        init{
            LOADED = NetworkState(Status.SUCCESS, "Success")
            LOADING = NetworkState(Status.RUNNING, "Running")
            ERROR = NetworkState(Status.FAILED, "Something went wrong")

        }
    }
}