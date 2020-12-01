package com.example.swvlmoviesapp.modules.search_screen.viewmodel

import android.os.Bundle
import android.view.View
import com.example.swvlmoviesapp.modules.movie_detail_screen.view.MovieDetailActivity
import com.example.swvlmoviesapp.modules.movies_list_screen.model.Movie
import com.example.swvlmoviesapp.utils.BaseViewModel

/**
 * ViewModel class for each search list item
 * @param movie
 */
class SearchItemViewModel(val movie: Movie) : BaseViewModel() {
    /**
     * For handling click on each recyclerview list item
     * Starts MovieDetailActivity
     * Finish self
     * @param view
     * @param movie
     */
    fun onItemClicked(view: View, movie: Movie) {
        val bundle = Bundle()
        bundle.putParcelable("movie", movie)
        startActivity(view.context, MovieDetailActivity::class, bundle)
        finishActivity(view.context)
    }
}