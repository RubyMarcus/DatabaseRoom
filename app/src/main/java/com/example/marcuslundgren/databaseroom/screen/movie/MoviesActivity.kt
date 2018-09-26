package com.example.marcuslundgren.databaseroom.screen.movie

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.widget.TextView
import com.example.marcuslundgren.databaseroom.R
import com.example.marcuslundgren.databaseroom.data.movie.Movie
import com.example.marcuslundgren.databaseroom.databinding.MainActivityBinding
import kotlinx.android.synthetic.main.main_activity.*

class MoviesActivity : AppCompatActivity() {

    lateinit var viewModel : MoviesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProviders.of(this, MovieViewModelFactory(
                this)
        ).get(MoviesViewModel::class.java)

        viewModel.showDialog.observe(this, object : Observer<Boolean>{
            override fun onChanged(showDialog: Boolean?) {
                showDialog?.let {
                    if(it) {
                        showAddDialog()
                    }
                }
            }
        })

        val binding : MainActivityBinding = DataBindingUtil.setContentView(
                this,
                R.layout.main_activity)
        binding.viewModel = viewModel
        binding.setLifecycleOwner(this)
        binding.executePendingBindings()

        val adapter = MovieAdapter(viewModel)

        movie_recyclerview.setHasFixedSize(true)
        movie_recyclerview.layoutManager = LinearLayoutManager(this)
        movie_recyclerview.adapter = adapter

        /*IO.execute{
            AppDatabase.getInstance(this)?.movieDao?.insert(Movie("Doctor Strange",
                "2016",
                "Action, Adventure, Fantasy"))}
        */
    }

    private fun showAddDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Add Movie")

        val view = layoutInflater.inflate(R.layout.movie_create_dialog,null)
        builder.setView(view)

        val title = view.findViewById(R.id.title_dialog_textview) as TextView
        val year = view.findViewById(R.id.release_year_dialog_textview) as TextView
        val genre = view.findViewById(R.id.genre_dialog_textview) as TextView

        builder.setPositiveButton(android.R.string.ok) { dialog, p ->
            viewModel.addMovie(Movie(title.text.toString(), year.text.toString(), genre.text.toString()))
        }

        builder.show()
    }
}
