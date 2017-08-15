package com.ezraerani.simplilearndemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MyRecyclerViewAdapter adapter;
    List<Movie> movies = new ArrayList<>();
    TMDBClient tmdbClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        adapter = new MyRecyclerViewAdapter(movies, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false));

        tmdbClient = new RestClient().getTmdbClient();


//        Observable<List<Movie>> movieObservable = tmdbClient.getPopularMovies("bf28df9736231173987f5bf5572b0859");
//        movieObservable.subscribeOn(Schedulers.io())
//                .flatMap(new Function<List<Movie>, ObservableSource<?>>() {
//                    @Override
//                    public ObservableSource<?> apply(List<Movie> movies) throws Exception {
//                        return Observable.fromIterable(movies);
//                    }
//                })
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<Object>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.d("OBSERVABLE", "onSubscribe");
//                    }
//
//                    @Override
//                    public void onNext(Object value) {
//                        Log.d("OBSERVABLE", "onNext");
//                        movies.add((Movie) value);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d("OBSERVABLE", e.getMessage());
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d("OBSERVABLE", "onComplete");
//                        adapter.notifyDataSetChanged();
//                    }
//                });

        Call<MovieResponse> movieResponseCall = tmdbClient.getPopularMovies("bf28df9736231173987f5bf5572b0859");
        movieResponseCall.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                MovieResponse movieResponse = response.body();
                movies.addAll(movieResponse.getResults());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {

            }
        });

    }
}
