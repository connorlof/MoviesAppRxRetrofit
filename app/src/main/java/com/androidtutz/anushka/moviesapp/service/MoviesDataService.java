package com.androidtutz.anushka.moviesapp.service;

import com.androidtutz.anushka.moviesapp.model.MovieDBResponse;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MoviesDataService {

    //Example without Rx
//    @GET("movie/popular")
//    Call<MovieDBResponse> getPopularMovies(@Query("api_key") String apiKey);

    //Example with Rx
    @GET("movie/popular")
    Observable<MovieDBResponse> getPopularMoviesWithRx(@Query("api_key") String apiKey);

}
