package com.example.swvlmoviesapp.modules.movies_list_screen.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.swvlmoviesapp.R
import com.example.swvlmoviesapp.databinding.ActivityMoviesListBinding
import com.example.swvlmoviesapp.modules.movies_list_screen.viewmodel.MovieListViewModel

/**
 * Movies list activity class
 */
class MoviesListActivity : AppCompatActivity() {
    private val viewModel by lazy {
        ViewModelProvider(this).get(MovieListViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpBinding()
    }

    /**
     * Binding viewmodel with view
     */
    private fun setUpBinding() {
        val binding = DataBindingUtil.setContentView<ActivityMoviesListBinding>(
            this,
            R.layout.activity_movies_list
        )
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        setUpToolbar(binding)
    }

    /**
     * Setting up toolbar
     * @param binding
     */
    private fun setUpToolbar(binding: ActivityMoviesListBinding) {
        setSupportActionBar(binding.toolbar)
    }
}