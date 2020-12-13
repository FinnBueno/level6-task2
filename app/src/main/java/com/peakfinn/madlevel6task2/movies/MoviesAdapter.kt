package com.peakfinn.madlevel6task2.movies

import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.peakfinn.madlevel6task2.data.Movie

/**
 * Created by Finn Bon on 13/12/2020.
 */
class MoviesAdapter(private val movies: List<Movie>, private val onClick: (Movie) -> Unit): RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: MenuView.ItemView) : RecyclerView.ViewHolder() {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}