package com.example.swvlmoviesapp.repository

import com.example.swvlmoviesapp.modules.movie_detail_screen.model.FlickrResponse
import com.example.swvlmoviesapp.network.NetworkResource
import com.example.swvlmoviesapp.network.NetworkResponseHandler
import com.example.swvlmoviesapp.network.RestService

/**
 * Image Repository class for feeding data to viewmodel.
 */
class ImagesRepository {
    /**
     * Suspend function to call flickr api and handle its response.
     * @param movieName
     * @return NetworkResource<FlickrResponse>
     */
    suspend fun getImagesFromFlickr(movieName: String?): NetworkResource<FlickrResponse> {
        return try {
            val response =
                RestService.getClient().getMovieImagesFromFlickrAsync(movieName = movieName).await()
            if (response.isSuccessful) {
                NetworkResponseHandler().handleSuccess(response.body(), response.code())
            } else {
                NetworkResponseHandler().handleException(statusCode = response.code())
            }
        } catch (e: Exception) {
            NetworkResponseHandler().handleException(e)
        }

    }
}