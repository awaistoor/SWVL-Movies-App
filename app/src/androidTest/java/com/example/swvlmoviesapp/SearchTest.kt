package com.example.swvlmoviesapp

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.swvlmoviesapp.modules.search_screen.viewmodel.SearchViewModel
import com.example.swvlmoviesapp.repository.MovieRepository
import com.example.swvlmoviesapp.utils.BaseViewModel
import junit.framework.TestCase.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Unit test class for testing searching functionality
 */
@RunWith(AndroidJUnit4::class)
class SearchTest {
    private lateinit var searchViewModel: SearchViewModel

    @Before
    fun setUp() {
        /// load list to baseviewmodel for test
        BaseViewModel.movieList =
            MovieRepository().getMoviesList(SWVLMoviesApp.getInstance()).movies ?: arrayListOf()
        /// initialize search view model
        searchViewModel = SearchViewModel()

    }

    /**
     * Test for function getSearchList by giving correct keyword
     */
    @Test
    fun validate_getSearchList_with_correct_keyword() {
        Thread.sleep(5 * 1000) /// adding delay to make sure list is loaded
        val searchList = searchViewModel.getSearchedList("summer")
        assertTrue(!searchList.isNullOrEmpty())
    }

    /**
     * Test for function getSearchList by giving incorrect keyword
     */
    @Test
    fun validate_getSearchList_with_incorrect_keyword() {

        Thread.sleep(5 * 1000) /// adding delay to make sure list is loaded
        val searchList = searchViewModel.getSearchedList("9002232")
        assertTrue(searchList.isNullOrEmpty())
    }

    /**
     * Test for function sortAndLimitSearchedList by giving the array and check if the limit
     * of 5 is correct
     */
    @Test
    fun validate_sortAndLimitSearchedList_item_limit_correct() {
        Thread.sleep(5 * 1000) /// adding delay to make sure list is loaded
        val searchList = searchViewModel.getSearchedList("summer")
        val result = searchViewModel.sortAndLimitSearchedList(
            searchList[2009] ?: error("Cannot perform test with empty list")
        )
        assertTrue(result.size <= 5)
    }
}