package com.example.swvlmoviesapp.modules.search_screen.viewmodel

import androidx.appcompat.widget.SearchView
import androidx.lifecycle.MutableLiveData
import com.example.swvlmoviesapp.modules.movies_list_screen.model.Movie
import com.example.swvlmoviesapp.modules.search_screen.adapter.SearchAdapter
import com.example.swvlmoviesapp.utils.BaseViewModel
import kotlinx.coroutines.*

/**
 * Viewmodel class for Search Activity view
 */
class SearchViewModel : BaseViewModel() {

    val adapter = SearchAdapter()

    // register query text listener for SearchView
    val queryListener = object : SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(query: String?): Boolean {
            search(query)
            return false
        }

        override fun onQueryTextChange(newText: String?): Boolean {
            search(newText)
            return false
        }

    }

    /**
     * Search function to search minimum 5 movies from the list with given keyword
     * the output list is grouped by year
     * the final list is then submitted to view
     * @param keyword
     */
    fun search(keyword: String?) {
        if (!keyword?.trim().isNullOrBlank()) { // check if the keyword is not null or empty
            CoroutineScope(Dispatchers.IO + Job()).launch {
                val searchList: Map<Int, List<Movie>> = getSearchedList(keyword)
                withContext(Dispatchers.Main) {
                    /// mutable live data object for passing list to view
                    val movieList = MutableLiveData<ArrayList<Movie>>()
                    if (searchList.isNotEmpty()) { // checking if searchlist is not empty
                        val finalList =
                            ArrayList<Movie>() /// creating a final list to store final output list
                        for ((index, value) in searchList) {
                            // adding header on each group item with year
                            finalList.add(
                                Movie(
                                    cast = null,
                                    genres = null,
                                    rating = null,
                                    title = null,
                                    year = index,
                                    isItemHeader = true
                                )
                            )
                            // adding rest of the sorted list
                            finalList.addAll(sortAndLimitSearchedList(value))
                        }
                        movieList.value = finalList
                    } else {
                        movieList.value = arrayListOf()
                    }
                    /// submitting list to the adapter.
                    adapter.submitList(movieList.value)

                }
            }
        } else {
            // clearing the list and updating the adapter when there is no keyword
            val movieList = MutableLiveData<ArrayList<Movie>>()
            movieList.value = arrayListOf()
            adapter.submitList(movieList.value)
        }
    }

    /**
     * Get search list which is filtered with keyword
     * List is also grouped by year
     * @param keyword
     * @return Map<Int, List<Movie>>
     */
    fun getSearchedList(keyword: String?): Map<Int, List<Movie>> {
        return movieList.filter {
            it.title.toString()
                .contains(keyword!!, true) /// filtering movies list with the keyword
        }.groupBy {
            it.year ?: 0 /// grouping the result with year
        }
    }

    /**
     * Function to sort descending and limit the List<Movie> to 5 items
     * @param value
     * @return List<Movie>
     */
    fun sortAndLimitSearchedList(value: List<Movie>): List<Movie> {

        return value.toList().subList(
            0,
            if (value.size >= 5) 5 else value.size // making sure that size of the search should not exceed by 5
        ).sortedByDescending {
            it.rating /// sorting the array with high rating to low rating
        }


    }

}