package com.peakfinn.madlevel6task2.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.peakfinn.madlevel6task2.BuildConfig

const val key = BuildConfig.MOVIEDB_KEY

/**
 * Created by Finn Bon on 13/12/2020.
 */
class MovieRepository {
    private val apiService: MovieApiService = MovieApi.createApi()

    private val _movies: MutableLiveData<ArrayList<Movie>> = MutableLiveData()

    val movies: LiveData<ArrayList<Movie>>
        get() = _movies

    suspend fun getMovies(year: Int)  {
        try {
            _movies.value = apiService.getMovies(key, year).movies
        } catch (error: Throwable) {
            throw MovieRefreshError("Unable to get popular movies", error)
        }
    }

    class MovieRefreshError(message: String, cause: Throwable) : Throwable(message, cause)
}