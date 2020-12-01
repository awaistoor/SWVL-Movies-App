package com.example.swvlmoviesapp.modules.movies_list_screen.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * Data class for movies json list model.
 * @param movies
 */
@Parcelize
data class MoviesModel(
    @SerializedName("movies")
    val movies: ArrayList<Movie>?
) : Parcelable

@Parcelize
data class Movie(
    @SerializedName("cast")
    val cast: ArrayList<String>?,
    @SerializedName("genres")
    val genres: ArrayList<String>?,
    @SerializedName("rating")
    val rating: Int?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("year")
    val year: Int?,
    /// custom flag for making header in search list
    var isItemHeader: Boolean = false
) : Parcelable {
    /**
     * To get cast list in comma separated string
     * @return String
     */
    fun getCastInCommaSeparatedString(): String? {
        return cast?.joinToString()
    }
}