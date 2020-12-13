package com.peakfinn.madlevel6task2.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

const val key: String = "" // TODO

/**
 * Created by Finn Bon on 13/12/2020.
 */
class MovieRepository {
    private val apiService: MovieApiService = MovieApi.createApi()

    private val _movies: MutableLiveData<ArrayList<Movie>> = MutableLiveData()

    val trivia: LiveData<ArrayList<Movie>>
        get() = _movies

    suspend fun getMovies(year: Int)  {
        try {
            //timeout the request after 5 seconds
            _movies.value = apiService.getMovies(key, year).movies
        } catch (error: Throwable) {
            throw TriviaRefreshError("Unable to get popular movies", error)
        }
    }

    class TriviaRefreshError(message: String, cause: Throwable) : Throwable(message, cause)
}