package com.example.swvlmoviesapp.modules.movie_detail_screen.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.swvlmoviesapp.R
import com.example.swvlmoviesapp.SWVLMoviesApp
import com.example.swvlmoviesapp.modules.movie_detail_screen.adapter.GenreBadgeListAdapter
import com.example.swvlmoviesapp.modules.movie_detail_screen.adapter.MoviesGalleryAdapter
import com.example.swvlmoviesapp.modules.movie_detail_screen.model.Photo
import com.example.swvlmoviesapp.repository.ImagesRepository
import com.example.swvlmoviesapp.modules.movies_list_screen.model.Movie
import com.example.swvlmoviesapp.utils.BaseViewModel
import com.example.swvlmoviesapp.utils.Constants
import com.example.swvlmoviesapp.utils.showToast
import kotlinx.coroutines.*

/**
 * ViewModel class for movie detail activity
 * @param movie
 */
class MovieDetailViewModel(val movie: Movie) : BaseViewModel() {

    val genreAdapter = GenreBadgeListAdapter()
    val galleryAdapter = MoviesGalleryAdapter()
    val isProgress = MutableLiveData<Boolean>(false)
    private val galleryList = MutableLiveData<ArrayList<Photo>>()

    init {
        isProgress.value = true
        genreAdapter.submitList(movie.genres)
        CoroutineScope(Dispatchers.IO + Job()).launch {
            /// calling image repository to fetch gallery images for movie
            val response = ImagesRepository().getImagesFromFlickr(movie.title)
            withContext(Dispatchers.Main) {
                isProgress.value = false
                when (response.status) {
                    Constants.Status.SUCCESS -> {
                        /// handling success response here.
                        if (!response.data?.photos?.photo.isNullOrEmpty()) {
                            galleryList.value = response.data?.photos?.photo
                            galleryAdapter.submitList(galleryList.value)
                        } else {
                            showToast(message = SWVLMoviesApp.getInstance().resources.getString(R.string.no_image_found_error))
                        }
                    }
                    Constants.Status.NO_INTERNET_CONNECTION -> {
                        showToast(message = response.message!!)
                    }

                    Constants.Status.ERROR -> {
                        showToast(message = response.message!!)
                    }


                }
            }
        }

    }
}