package com.example.swvlmoviesapp.modules.movies_list_screen.viewmodel

import android.os.Bundle
import android.view.View
import com.example.swvlmoviesapp.modules.movie_detail_screen.view.MovieDetailActivity
import com.example.swvlmoviesapp.modules.movies_list_screen.model.Movie
import com.example.swvlmoviesapp.utils.BaseViewModel

/**
 * Movies list item viewmodel class
 * @param movie
 */
class MovieListItemViewModel(val movie: Movie) : BaseViewModel() {
    /**
     * On each item of recycler view clicked
     * Starts MovieDetailActivity with extra passed
     * @param view
     * @param movie
     */
    fun onItemClicked(view: View, movie: Movie) {
        val bundle = Bundle()
        bundle.putParcelable("movie", movie)
        startActivity(view.context, MovieDetailActivity::class, bundle)
    }
}