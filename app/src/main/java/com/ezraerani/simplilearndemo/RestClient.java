package com.ezraerani.simplilearndemo;

import android.util.Log;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ezraerani on 8/14/17.
 */

public class RestClient {

    private TMDBClient tmdbClient;

    public RestClient() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        tmdbClient = retrofit.create(TMDBClient.class);

    }

    public TMDBClient getTmdbClient() {
        Log.d("RestClient", "returning TMDB client");
        return tmdbClient;
    }
}
