package com.example.swvlmoviesapp.modules.movie_detail_screen.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

/**
 * Response Model class for Flickr API response.
 */
@Keep
data class FlickrResponse(
    @SerializedName("photos")
    val photos: Photos?,
    @SerializedName("stat")
    val stat: String?
)
@Keep
data class Photos(
    @SerializedName("page")
    val page: Int?,
    @SerializedName("pages")
    val pages: Int?,
    @SerializedName("perpage")
    val perpage: Int?,
    @SerializedName("photo")
    val photo: ArrayList<Photo>?,
    @SerializedName("total")
    val total: String?
)
@Keep
data class Photo(
    @SerializedName("farm")
    val farm: Int?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("isfamily")
    val isfamily: Int?,
    @SerializedName("isfriend")
    val isfriend: Int?,
    @SerializedName("ispublic")
    val ispublic: Int?,
    @SerializedName("owner")
    val owner: String?,
    @SerializedName("secret")
    val secret: String?,
    @SerializedName("server")
    val server: String?,
    @SerializedName("title")
    val title: String?
)