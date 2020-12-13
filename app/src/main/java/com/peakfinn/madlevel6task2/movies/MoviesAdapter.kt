package com.peakfinn.madlevel6task2.movies

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.peakfinn.madlevel6task2.R
import com.peakfinn.madlevel6task2.data.Movie
import com.peakfinn.madlevel6task2.data.MovieApi
import kotlinx.android.synthetic.main.item_movie.view.*

/**
 * Created by Finn Bon on 13/12/2020.
 */
class MoviesAdapter(private val movies: List<Movie>, private val onClick: (Movie) -> Unit): RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    private lateinit var context: Context

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener { onClick(movies[adapterPosition]) }
        }
        fun bind(movie: Movie) {
            itemView.movieNumber.text = movie.title
            Glide.with(context).load(MovieApi.imageUrl + movie.image).into(itemView.movieImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false)
        )
    }

    override fun getItemCount() = movies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(movies[position])
}