package com.androidtutz.anushka.moviesapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.androidtutz.anushka.moviesapp.R;
import com.androidtutz.anushka.moviesapp.model.Movie;
import com.androidtutz.anushka.moviesapp.view.MovieActivity;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by K. A. ANUSHKA MADUSANKA on 7/4/2018.
 */
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder>{

    private Context context;
    private ArrayList<Movie> movies;

    public MovieAdapter(Context context, ArrayList<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {



        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_item,parent,false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {

        holder.movieTitle.setText(movies.get(position).getOriginalTitle());
        holder.rate.setText(Double.toString(movies.get(position).getVoteAverage()));

        String posterPath="https://image.tmdb.org/t/p/w500"+ movies.get(position).getPosterPath();

        Glide.with(context)
                .load(posterPath)
                .placeholder(R.drawable.loading)
                .into(holder.movieImage);

    }

    @Override
    public int getItemCount() {

        return movies.size();
    }


    public class MovieViewHolder extends RecyclerView.ViewHolder{

        public TextView movieTitle,rate;
        public ImageView movieImage;






        public MovieViewHolder(View itemView) {
            super(itemView);

            movieTitle=itemView.findViewById(R.id.tvTitle);
            rate=itemView.findViewById(R.id.tvRating);
            movieImage=itemView.findViewById(R.id.ivMovie);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int position = getAdapterPosition();

                    if (position != RecyclerView.NO_POSITION){
                        Movie selectedMovie = movies.get(position);
                        Intent intent = new Intent(context, MovieActivity.class);
                        intent.putExtra("movie", selectedMovie );
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        String movieTitle=selectedMovie.getOriginalTitle();
                        Toast.makeText(view.getContext(),  movieTitle, Toast.LENGTH_LONG).show();

                        context.startActivity(intent);
                    }

                }
            });
        }
    }


}
