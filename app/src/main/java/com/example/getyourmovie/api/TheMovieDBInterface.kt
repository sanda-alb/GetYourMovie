package com.example.getyourmovie.api

import com.example.getyourmovie.data_vo.MovieDetails
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

//https://api.themoviedb.org/3/movie/popular?api_key=bb340add54f4429cc9cb320eeb25ba8c&language=en-US&page=1
//https://api.themoviedb.org/3/movie/299534?api_key=bb340add54f4429cc9cb320eeb25ba8c&language=en-US&page=1
//https://api.themoviedb.org/3/
interface TheMovieDBInterface {

    @GET("movie/{movie_id}")
    fun getMovieDetails(@Path("movie_id") id: Int): Single<MovieDetails>
}