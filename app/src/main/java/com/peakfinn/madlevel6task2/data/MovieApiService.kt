package com.peakfinn.madlevel6task2.data

import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Finn Bon on 13/12/2020.
 */
interface MovieApiService {
    // The GET method needed to retrieve a random number trivia.
    @GET("/discover/movie?json")
    suspend fun getMovies(
        @Query("apiKey") api_key: String,
        @Query("year") year: Int
    ): Movies
}