package com.example.marcuslundgren.databaseroom.screen.movie

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.marcuslundgren.databaseroom.data.movie.Movie

class MovieAdapter(val viewModel: MoviesViewModel) : RecyclerView.Adapter<MovieViewHolder>() {

    private var movies:List<Movie> = ArrayList()

    fun setMovies(movies:List<Movie>) {
        this.movies = movies
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, type: Int): MovieViewHolder = MovieViewHolder.newInstance(parent, viewModel)

    override fun onBindViewHolder(movieViewHolder: MovieViewHolder, position: Int) = movieViewHolder.bind(movies[position])

    override fun getItemCount(): Int = movies.size
}