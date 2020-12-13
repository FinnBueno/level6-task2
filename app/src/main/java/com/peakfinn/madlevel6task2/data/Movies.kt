package com.peakfinn.madlevel6task2.data

import android.os.Parcelable
import androidx.core.os.bundleOf
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

const val TITLE = "title"
const val POSTER = "poster"
const val OVERVIEW = "overview"
const val RELEASE_DATE= "releaseDate"
const val BACKDROP = "backdrop"

/**
 * Created by Finn Bon on 13/12/2020.
 */
data class Movies(
    @SerializedName("results") var movies: ArrayList<Movie>
)

@Parcelize
data class Movie(
    @SerializedName("title") var title: String,
    @SerializedName("poster_path") var image: String,
    @SerializedName("overview") var overview: String,
    @SerializedName("release_date") var releaseDate: String,
    @SerializedName("backdrop_path") var backdrop: String
) : Parcelable {
    fun toBundle() = bundleOf(
        TITLE to title,
        POSTER to image,
        OVERVIEW to overview,
        RELEASE_DATE to releaseDate,
        BACKDROP to backdrop
    )
}
