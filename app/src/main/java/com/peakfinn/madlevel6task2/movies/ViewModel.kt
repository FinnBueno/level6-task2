package com.peakfinn.madlevel6task2.movies

import android.app.Application
import androidx.lifecycle.*
import com.peakfinn.madlevel6task2.data.MovieRepository
import kotlinx.coroutines.launch

/**
 * Created by Finn Bon on 13/12/2020.
 */
class MoviesViewModel(application: Application) : AndroidViewModel(application) {

    private val repo = MovieRepository()

    val movies = repo.movies

    private val _errorText: MutableLiveData<String> = MutableLiveData()

    val errorText: LiveData<String>
        get() = _errorText

    fun getMovies(year: Int) {
        viewModelScope.launch {
            try {
                repo.getMovies(year)
            } catch (error: MovieRepository.MovieRefreshError) {
                _errorText.value = error.message
            }
        }
    }
}