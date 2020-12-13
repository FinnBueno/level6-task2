package com.peakfinn.madlevel6task2.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

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
    @SerializedName("vote_average") var voteAverage: Double,
    @SerializedName("backdrop_path") var backdrop: String
) : Parcelable
