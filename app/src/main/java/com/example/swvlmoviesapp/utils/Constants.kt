package com.example.swvlmoviesapp.utils

/**
 * Constants file for the app
 */
object Constants {
    /**
     * EndPoint constants for Retrofit
     */
    object EndPoints {
        const val FLICKR_PHOTO_SEARCH = "services/rest/"
    }

    /**
     * RestConstants for Rest APIs
     */

    object RestConstants {
        const val FLICKR_BASE_URL = "https://api.flickr.com/"
        const val FLICKR_PUBLIC_API_KEY = "63dacc24b51802e62aac3c479e566a1c"
    }

    /**
     * List Item Types
     */
    object ListItemTypes {
        const val TYPE_HEADER = 0
        const val TYPE_ITEM = 1
    }

    /**
     * Status for Network Response
     */
    enum class Status {
        SUCCESS,
        ERROR,
        NO_INTERNET_CONNECTION
    }
}