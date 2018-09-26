package com.example.marcuslundgren.databaseroom.screen.movie

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.marcuslundgren.databaseroom.data.movie.Movie
import com.example.marcuslundgren.databaseroom.data.movie.MovieDao
import com.example.marcuslundgren.databaseroom.data.movie.MovieRepository
import com.example.marcuslundgren.databaseroom.utils.IO
import com.example.marcuslundgren.databaseroom.utils.SingleLiveEvent
import com.example.marcuslundgren.databaseroom.utils.UI

class MoviesViewModel(val repo: MovieRepository) : ViewModel () {

    val moviesLiveData = repo.read()

    val showDialog = SingleLiveEvent<Boolean>()

    fun addMovie(movie: Movie) {
        IO.execute {
            repo.create(movie)
        }
    }

    fun deleteMovie(movie: Movie) {
        IO.execute {
            repo.delete(movie)
        }
    }

    fun showCreateDialog() {
        showDialog.postValue(true)
    }
}