package com.example.swvlmoviesapp.modules.movies_list_screen.viewmodel

import android.view.View
import androidx.lifecycle.MutableLiveData
import com.example.swvlmoviesapp.SWVLMoviesApp
import com.example.swvlmoviesapp.modules.movies_list_screen.adapter.MoviesAdapter
import com.example.swvlmoviesapp.modules.search_screen.view.SearchActivity
import com.example.swvlmoviesapp.repository.MovieRepository
import com.example.swvlmoviesapp.utils.BaseViewModel
import kotlinx.coroutines.*

/**
 * View model class for Movie list Activity
 */
class MovieListViewModel : BaseViewModel() {

    val moviesAdapter = MoviesAdapter()
    val isProgress = MutableLiveData<Boolean>(false)

    init {
        isProgress.value = true
        /// fetch and submit movies list from Movies repository
        CoroutineScope(Dispatchers.IO + Job()).launch {
            /// clearing and loading movie list each time activity launch
            movieList.clear()
            movieList.addAll(
                MovieRepository().getMoviesList(SWVLMoviesApp.getInstance()).movies ?: arrayListOf()
            )
            withContext(Dispatchers.Main) {
                moviesAdapter.submitList(movieList)
                isProgress.value = false
            }
        }

    }

    /**
     * On search icon clicked
     * Starts SearchActivity
     * @param view
     */
    fun onSearchClicked(view: View) {
        startActivity(view.context, SearchActivity::class)
    }
}