package com.example.swvlmoviesapp.repository

import android.content.Context
import com.example.swvlmoviesapp.R
import com.example.swvlmoviesapp.modules.movies_list_screen.model.MoviesModel
import com.google.gson.Gson

/**
 * Movies repository class for feeding data to viewmodel
 */
class MovieRepository {

  /**
   * Read and parse movies model from movies json file to MoviesModel object.
   * @param context
   * @return MoviesModel
   * */
    fun getMoviesList(context: Context): MoviesModel {
        val text = context.resources.openRawResource(R.raw.movies)
            .bufferedReader().use { it.readText() }
        return Gson().fromJson(text, MoviesModel::class.java)
    }


}