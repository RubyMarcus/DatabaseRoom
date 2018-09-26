package com.example.marcuslundgren.databaseroom.data.movie

import android.arch.lifecycle.LiveData

class MovieRepositoryRoom(val movieDao: MovieDao) :  MovieRepository {

    override fun create(vararg movie: Movie) = movieDao.insert(*movie)

    override fun read(): LiveData<List<Movie>> = movieDao.getAllMovies()

    override fun update(vararg movie: Movie) = movieDao.update(*movie)

    override fun delete(vararg movie: Movie) = movieDao.delete(*movie)
}