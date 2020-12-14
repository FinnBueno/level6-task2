package com.peakfinn.madlevel6task2.movies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.peakfinn.madlevel6task2.R
import com.peakfinn.madlevel6task2.data.Movie
import kotlinx.android.synthetic.main.fragment_movies.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class MoviesFragment : Fragment() {

    private val movies = arrayListOf<Movie>()
    private val adapter =
        MoviesAdapter(movies) { movie ->
            onMovieClicked(movie)
        }
    private val viewModel: MoviesViewModel by activityViewModels()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    private fun onMovieClicked(movie: Movie) {
        findNavController().navigate(R.id.movies_to_movie, movie.toBundle())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        submitButton.setOnClickListener {
            viewModel.getMovies(yearInput.text.toString().toInt())
        }

//        moviesRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        moviesRv.layoutManager = GridLayoutManager(context, 2, LinearLayoutManager.VERTICAL, false)
        moviesRv.adapter = adapter

        observeYear()
    }

    private fun observeYear() {
        viewModel.movies.observe(viewLifecycleOwner, Observer { movie ->
            movies.clear()
            movies.addAll(movie)
            adapter.notifyDataSetChanged()
        })
    }
}