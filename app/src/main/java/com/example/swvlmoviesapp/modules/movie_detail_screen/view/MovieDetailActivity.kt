package com.example.swvlmoviesapp.modules.movie_detail_screen.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.swvlmoviesapp.R
import com.example.swvlmoviesapp.databinding.ActivityMovieDetailBinding
import com.example.swvlmoviesapp.modules.movie_detail_screen.viewmodel.MovieDetailViewModel
import com.example.swvlmoviesapp.modules.movies_list_screen.model.Movie

/**
 * Movie Detail Activity Class
 **/

class MovieDetailActivity : AppCompatActivity() {
    lateinit var movie: Movie
    private val viewModel by lazy {
        @Suppress("UNCHECKED_CAST")
        ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return MovieDetailViewModel(movie) as T
            }

        }).get(MovieDetailViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpBinding()
    }

    /**
     * Binding viewmodel with view
     */
    private fun setUpBinding() {
        movie = intent.getBundleExtra("bundle")?.getParcelable("movie")!!
        val binding = DataBindingUtil.setContentView<ActivityMovieDetailBinding>(
            this,
            R.layout.activity_movie_detail
        )
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        setUpToolbar(binding)
    }

    /**
     * Setting up toolbar
     * @param binding
     */
    private fun setUpToolbar(binding: ActivityMovieDetailBinding) {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    /**
     * On back button pressed on toolbar
     */
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}