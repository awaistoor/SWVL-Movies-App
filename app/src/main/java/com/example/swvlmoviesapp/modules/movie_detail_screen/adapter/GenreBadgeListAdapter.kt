package com.example.swvlmoviesapp.modules.movie_detail_screen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.swvlmoviesapp.R
import com.example.swvlmoviesapp.databinding.HolderGenreBadgesBinding

/**
 * Genre badge list adapter for showing genre in badges.
 */
class GenreBadgeListAdapter :
    ListAdapter<String, GenreBadgeListAdapter.ItemViewHolder>(DiffCallBack) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = DataBindingUtil.inflate<HolderGenreBadgesBinding>(
            LayoutInflater.from(parent.context),
            R.layout.holder_genre_badges, parent, false
        )
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ItemViewHolder internal constructor(private val binding: HolderGenreBadgesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(genre: String) {
            binding.genre = genre
        }
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(
            oldItem: String,
            newItem: String
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: String,
            newItem: String
        ): Boolean {
            return oldItem == newItem
        }
    }


}