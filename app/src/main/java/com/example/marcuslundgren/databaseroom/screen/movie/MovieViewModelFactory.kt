package com.example.marcuslundgren.databaseroom.screen.movie

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import com.example.marcuslundgren.databaseroom.data.AppDatabase
import com.example.marcuslundgren.databaseroom.data.movie.MovieRepositoryRoom

@Suppress("UNCHECKED_CAST")
class MovieViewModelFactory(val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MoviesViewModel(MovieRepositoryRoom(AppDatabase.getInstance(context)?.movieDao!!)) as T
    }
}