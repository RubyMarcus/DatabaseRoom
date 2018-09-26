package com.example.marcuslundgren.databaseroom.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.marcuslundgren.databaseroom.data.movie.Movie
import com.example.marcuslundgren.databaseroom.data.movie.MovieDao

@Database(entities = arrayOf(Movie::class), version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {

    abstract val movieDao: MovieDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                            AppDatabase::class.java, "database.db")
                            .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}