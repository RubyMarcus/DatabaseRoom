package com.example.marcuslundgren.databaseroom.screen.movie

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.marcuslundgren.databaseroom.R
import com.example.marcuslundgren.databaseroom.data.movie.Movie
import com.example.marcuslundgren.databaseroom.databinding.MovieRowBinding

class MovieViewHolder(val binding: MovieRowBinding) :RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: Movie) {
        binding.movie = movie
    }

    companion object {
        fun newInstance(parent: ViewGroup, viewModel: MoviesViewModel) : MovieViewHolder {
            val binding : MovieRowBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                    R.layout.movie_row, parent, false)

            binding.viewModel = viewModel
            binding.executePendingBindings()

            return MovieViewHolder (
                    binding
            )
        }
    }
}