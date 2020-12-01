package com.example.swvlmoviesapp.modules.search_screen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.swvlmoviesapp.R
import com.example.swvlmoviesapp.databinding.HolderSearchHeaderBinding
import com.example.swvlmoviesapp.databinding.HolderSearchItemBinding
import com.example.swvlmoviesapp.modules.movies_list_screen.model.Movie
import com.example.swvlmoviesapp.modules.search_screen.viewmodel.SearchItemViewModel
import com.example.swvlmoviesapp.utils.Constants

/**
 * Adapter class for search list
 */
class SearchAdapter : ListAdapter<Movie, RecyclerView.ViewHolder>(DiffCallBack) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        /// handling multiple view types in list
        return when (viewType) {
            // if the view type is item
            Constants.ListItemTypes.TYPE_ITEM -> {
                val binding = DataBindingUtil.inflate<HolderSearchItemBinding>(
                    LayoutInflater.from(parent.context),
                    R.layout.holder_search_item, parent, false
                )
                ItemViewHolder(binding)
            }
            // if the view type is header
            Constants.ListItemTypes.TYPE_HEADER -> {
                val binding = DataBindingUtil.inflate<HolderSearchHeaderBinding>(
                    LayoutInflater.from(parent.context),
                    R.layout.holder_search_header, parent, false
                )
                HeaderViewHolder(binding)
            }
            // handling else case as view type item
            else -> {
                val binding = DataBindingUtil.inflate<HolderSearchItemBinding>(
                    LayoutInflater.from(parent.context),
                    R.layout.holder_search_item, parent, false
                )
                ItemViewHolder(binding)
            }
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            // binding item view
            is ItemViewHolder -> {
                holder.bind(getItem(position))
            }
            // binding header view
            is HeaderViewHolder -> {
                holder.bind(getItem(position).year.toString())
            }
        }

    }

    inner class ItemViewHolder internal constructor(private val binding: HolderSearchItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            binding.viewModel = SearchItemViewModel(movie)
        }
    }

    inner class HeaderViewHolder internal constructor(private val binding: HolderSearchHeaderBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(year: String) {
            binding.year = year
        }
    }

    override fun getItemViewType(position: Int): Int {
        // check which item has isItemHeader flag set to true
        // if its true then return TYPE_HEADER
        // if its false then return TYPE_ITEM
        return if (getItem(position).isItemHeader) Constants.ListItemTypes.TYPE_HEADER else Constants.ListItemTypes.TYPE_ITEM
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