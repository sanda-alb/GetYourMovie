package com.example.getyourmovie.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.getyourmovie.api.TheMovieDBInterface
import com.example.getyourmovie.data_vo.MovieDetails
import io.reactivex.disposables.CompositeDisposable

class MovieDetailsNetworkDataSource(
    private val apiService: TheMovieDBInterface,
    private val compositDesposable: CompositeDisposable) {

    private val _networkState = MutableLiveData<NetworkState>()
    val networkState: LiveData<NetworkState>
    get() = _networkState

    private val _downloadedMovieDetailsResponce = MutableLiveData<MovieDetails>()
    val downloadedMovieDetailsResponce: LiveData<MovieDetails>
    get() = _downloadedMovieDetailsResponce



}