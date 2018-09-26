package com.example.marcuslundgren.databaseroom.utils

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import com.example.marcuslundgren.databaseroom.data.movie.Movie
import com.example.marcuslundgren.databaseroom.screen.movie.MovieAdapter

@BindingAdapter("movies")
fun setMoviesAttr(recyclerView : RecyclerView, movies:List<Movie>?) {
    movies?.let { movieList  ->
        val adapter = recyclerView.adapter as MovieAdapter?
        adapter?.apply {
            setMovies(movieList)
        }
    }
}