package com.example.swvlmoviesapp.modules.movie_detail_screen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.swvlmoviesapp.R
import com.example.swvlmoviesapp.databinding.HolderImageItemBinding
import com.example.swvlmoviesapp.modules.movie_detail_screen.model.Photo

/**
 * Movies gallery adapter to show gallery grid view using flickr api.
 */
class MoviesGalleryAdapter : ListAdapter<Photo, MoviesGalleryAdapter.ItemViewHolder>(DiffCallBack) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = DataBindingUtil.inflate<HolderImageItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.holder_image_item, parent, false
        )
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ItemViewHolder internal constructor(private val binding: HolderImageItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(photo: Photo) {
            binding.photo = photo
        }
    }


    companion object DiffCallBack : DiffUtil.ItemCallback<Photo>() {
        override fun areItemsTheSame(
            oldItem: Photo,
            newItem: Photo
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: Photo,
            newItem: Photo
        ): Boolean {
            return oldItem == newItem
        }
    }


}