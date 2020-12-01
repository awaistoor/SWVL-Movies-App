package com.example.swvlmoviesapp.modules.movies_list_screen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.swvlmoviesapp.R
import com.example.swvlmoviesapp.databinding.HolderMovieItemBinding
import com.example.swvlmoviesapp.modules.movies_list_screen.model.Movie
import com.example.swvlmoviesapp.modules.movies_list_screen.viewmodel.MovieListItemViewModel

/**
 * Movie list adapter class
 */
class MoviesAdapter : ListAdapter<Movie, MoviesAdapter.ItemViewHolder>(DiffCallBack) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MoviesAdapter.ItemViewHolder {
        val binding = DataBindingUtil.inflate<HolderMovieItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.holder_movie_item, parent, false
        )
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MoviesAdapter.ItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ItemViewHolder internal constructor(private val binding: HolderMovieItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            binding.viewModel = MovieListItemViewModel(movie)
        }
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(
            oldItem: Movie,
            newItem: Movie
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: Movie,
            newItem: Movie
        ): Boolean {
            return oldItem.title == newItem.title
        }
    }
}

