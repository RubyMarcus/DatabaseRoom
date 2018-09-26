package com.example.marcuslundgren.databaseroom.data.movie

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*

@Dao
interface MovieDao {

    @Insert
    fun insert(vararg movies: Movie)

    @Query("SELECT * FROM movies")
    fun getAllMovies(): LiveData<List<Movie>>

    @Update
    fun update(vararg movies: Movie)

    @Delete
    fun delete(vararg movies: Movie)
}