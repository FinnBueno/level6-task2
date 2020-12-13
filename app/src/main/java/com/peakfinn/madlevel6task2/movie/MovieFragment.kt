package com.peakfinn.madlevel6task2.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.peakfinn.madlevel6task2.R
import com.peakfinn.madlevel6task2.data.*
import kotlinx.android.synthetic.main.fragment_movie.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class MovieFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        title.text = arguments?.getString(TITLE)
        date.text = arguments?.getString(RELEASE_DATE)
        description.text = arguments?.getString(OVERVIEW)
        Glide.with(this).load(MovieApi.imageUrl + arguments?.getString(BACKDROP)).into(backdrop)
        Glide.with(this).load(MovieApi.imageUrl + arguments?.getString(POSTER)).into(poster)
    }
}