package com.example.marcuslundgren.databaseroom.data.movie

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "movies")
data class Movie(
        @ColumnInfo(name = "movie_name") var movieName: String,
        @ColumnInfo(name = "movie_release_date_year") var movieReleaseDateYear: String,
        @ColumnInfo(name = "movie_genre") var movieGenre: String

) {
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "_id")
        var movieId: Long = 0
}