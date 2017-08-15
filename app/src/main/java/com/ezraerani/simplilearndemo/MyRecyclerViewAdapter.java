package com.ezraerani.simplilearndemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by ezraerani on 3/28/16.
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MovieStuffHolder>  {

    private final String TAG = getClass().getSimpleName();

    public List<Movie> movies;
    private final String baseURL = "http://image.tmdb.org/t/p/w342/";
    Context ctx;
    Picasso picasso;

    public MyRecyclerViewAdapter(List<Movie> movies, Context ctx) {
        this.movies = movies;
        this.ctx = ctx;
        picasso = Picasso.with(ctx);
        Log.d(TAG, "movies = " + movies.size());

    }

    @Override
    public MovieStuffHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new MovieStuffHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MovieStuffHolder holder, int position) {
        Movie selectedMovie = movies.get(position);
        String title = selectedMovie.getTitle();
        holder.movieTitle.setText(title);

        picasso.load(baseURL + selectedMovie.getPosterPath()).into(holder.movieImage);

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }


    public class MovieStuffHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView movieTitle;
        ImageView movieImage;
        public MovieStuffHolder(View itemView) {

            super(itemView);
            movieTitle = (TextView)itemView.findViewById(R.id.movietitle);
            movieImage = (ImageView) itemView.findViewById(R.id.movieimage);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            Toast.makeText(ctx, movieTitle.getText().toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
