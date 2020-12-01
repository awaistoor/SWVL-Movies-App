package com.example.swvlmoviesapp

import android.content.Context
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.swvlmoviesapp.repository.MovieRepository
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Test class for Movie lists
 */
@RunWith(AndroidJUnit4::class)
class MoviesListTest {
    lateinit var appContext: Context

    @Before
    fun setUp() {
        appContext = InstrumentationRegistry.getInstrumentation().targetContext
    }

    /**
     * Test case to check if list is loaded properly
     */
    @Test
    fun validate_movies_list_loaded_successfully() {
        val movieModel = MovieRepository().getMoviesList(appContext)
        assertTrue(!movieModel.movies.isNullOrEmpty())
    }

    /**
     * Test case to check if list is not loaded
     */
    @Test
    fun validate_movies_list_loaded_unsuccessfully() {
        val movieModel = MovieRepository().getMoviesList(appContext)
        assertFalse(movieModel.movies.isNullOrEmpty())
    }


}