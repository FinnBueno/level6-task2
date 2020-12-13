package com.peakfinn.madlevel6task2.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Finn Bon on 13/12/2020.
 */
class MovieApi {
    companion object {
        // The base url off the api.
        private const val baseUrl = "https://api.themoviedb.org/"

        // url for retrieving images
        const val imageUrl = "https://image.tmdb.org/t/p/w500/"

        /**
         * @return [TriviaApiService] The service class off the retrofit client.
         */
        fun createApi(): MovieApiService {
            // Create an OkHttpClient to be able to make a log of the network traffic
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()

            // Create the Retrofit instance
            val triviaApi = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            // Return the Retrofit TriviaApiService
            return triviaApi.create(MovieApiService::class.java)
        }
    }
}