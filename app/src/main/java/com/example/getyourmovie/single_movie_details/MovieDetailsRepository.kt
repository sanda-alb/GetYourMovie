package com.example.getyourmovie.single_movie_details

import androidx.lifecycle.LiveData
import com.example.getyourmovie.api.TheMovieDBInterface
import com.example.getyourmovie.data_vo.MovieDetails
import com.example.getyourmovie.repository.MovieDetailsNetworkDataSource
import com.example.getyourmovie.repository.NetworkState
import io.reactivex.disposables.CompositeDisposable

class MovieDetailsRepository(private val apiService: TheMovieDBInterface) {
    lateinit var movieDetailsNetworkDataSource: MovieDetailsNetworkDataSource

    fun fetchSingleMovieDetails(compositDesposable: CompositeDisposable, movieId: Int)
    : LiveData<MovieDetails>{
        movieDetailsNetworkDataSource = MovieDetailsNetworkDataSource(apiService, compositDesposable)
        movieDetailsNetworkDataSource.fetchMovieDetails(movieId)

        return movieDetailsNetworkDataSource.downloadedMovieDetailsResponse
    }

    fun getMovieDetailsNetworkState(): LiveData<NetworkState> {
        return movieDetailsNetworkDataSource.networkState
    }

}