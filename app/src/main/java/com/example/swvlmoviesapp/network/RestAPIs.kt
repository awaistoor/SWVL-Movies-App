package com.example.swvlmoviesapp.network

import com.example.swvlmoviesapp.modules.movie_detail_screen.model.FlickrResponse
import com.example.swvlmoviesapp.utils.Constants
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Endpoint interface class for Retrofit.
 */
interface RestAPIs {
    /**
     * Get Movies images from Flickr Photo Search API
     * @param api_key
     * @param format
     * @param method
     * @param movieName
     * @param nojsoncallback
     * @param page
     * @param per_page
     */
    @GET(Constants.EndPoints.FLICKR_PHOTO_SEARCH)
    fun getMovieImagesFromFlickrAsync(
        @Query(value = "method", encoded = true) method: String = "flickr.photos.search",
        @Query(
            value = "api_key",
            encoded = true
        ) api_key: String = Constants.RestConstants.FLICKR_PUBLIC_API_KEY,
        @Query(value = "format", encoded = true) format: String = "json",
        @Query(value = "nojsoncallback", encoded = true) nojsoncallback: Int = 1,
        @Query(value = "text", encoded = true) movieName: String?,
        @Query(value = "page", encoded = true) page: Int = 1,
        @Query(value = "per_page", encoded = true) per_page: Int = 10,
    ): Deferred<Response<FlickrResponse>>
}