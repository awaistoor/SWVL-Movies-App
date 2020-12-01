package com.example.swvlmoviesapp.utils

import android.widget.Toast
import com.example.swvlmoviesapp.SWVLMoviesApp
import com.example.swvlmoviesapp.modules.movie_detail_screen.model.Photo

/**
 * show toast anywhere in the app
 * @param message
 */
fun showToast(message: String) {
    Toast.makeText(SWVLMoviesApp.getInstance(), message, Toast.LENGTH_SHORT).show()
}

/**
 * get concatenated flickr link for glide.
 * @param photo
 */
fun getUrlForGlide(photo: Photo?): String {
    return if (photo != null) "https://farm${photo.farm}.static.flickr.com/${photo.server}/${photo.id}_${photo.secret}.jpg" else ""
}