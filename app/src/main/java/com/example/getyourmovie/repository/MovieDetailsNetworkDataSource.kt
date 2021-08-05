package com.example.getyourmovie.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.getyourmovie.api.TheMovieDBInterface
import com.example.getyourmovie.data_vo.MovieDetails
import com.example.getyourmovie.repository.NetworkState.Companion.LOADED
import com.example.getyourmovie.repository.NetworkState.Companion.LOADING
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MovieDetailsNetworkDataSource(
    private val apiService: TheMovieDBInterface,
    private val compositDesposable: CompositeDisposable) {

    private val _networkState = MutableLiveData<NetworkState>()
    val networkState: LiveData<NetworkState>
    get() = _networkState

    private val _downloadedMovieDetailsResponce = MutableLiveData<MovieDetails>()
    val downloadedMovieDetailsResponce: LiveData<MovieDetails>
    get() = _downloadedMovieDetailsResponce

    fun fetchMovieDetails(movieId: Int) {
        _networkState.postValue(LOADING)

        try{
        compositDesposable.add(
            apiService.getMovieDetails(movieId)
                .subscribeOn(Schedulers.io())
                .subscribe(
                    {
                        _downloadedMovieDetailsResponce.postValue(it)
                        _networkState.postValue(NetworkState.LOADED)
                    },
                    {
                        _networkState.postValue(NetworkState.ERROR)
                        Log.e("MovieDetailDataSource", it.message.toString())
                    }

                )
        )
        }

        catch(e: Exception){
            Log.e("MovieDetailDataSource", e.message.toString())
        }
    }




}