package com.ezraerani.simplilearndemo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by ezraerani on 8/14/17.
 */

public interface TMDBClient {
//    @GET("movie/popular")
//    Observable<List<Movie>> getPopularMovies(@Query("api_key") String API_key);

    @GET("movie/popular")
    Call<MovieResponse> getPopularMovies(@Query("api_key") String API_key);

    @GET("{path}/{user}")
    Call<MovieResponse> getSomethingElse(@Path("path") String path, @Path("user") String user);


}
