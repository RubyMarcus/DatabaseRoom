package com.example.marcuslundgren.databaseroom.data.movie

import android.arch.lifecycle.LiveData

interface MovieRepository {
    // Crud
    fun create(vararg movie: Movie)

    fun read(): LiveData<List<Movie>>

    fun update(vararg movie: Movie)

    fun delete(vararg movie: Movie)
}