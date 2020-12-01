package com.example.swvlmoviesapp.utils

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.core.widget.ContentLoadingProgressBar
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.swvlmoviesapp.R
import com.example.swvlmoviesapp.modules.movie_detail_screen.model.Photo

object BindingAdapters {
    /**
     * Binding adapter for loading images in ImageView using Glide
     * @param imageView
     * @param photo
     * @param progressBar
     */
    @JvmStatic
    @BindingAdapter("app:loadUrl", "app:progressBar")
    fun loadUrlToImageView(
        imageView: ImageView,
        photo: Photo?,
        progressBar: ContentLoadingProgressBar
    ) {
        val url = getUrlForGlide(photo)
        if (url.isNotBlank()) {
            Glide.with(imageView.context)
                .load(url).addListener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        progressBar.visibility = View.GONE
                        return false
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        progressBar.visibility = View.GONE
                        return false
                    }
                })
                .error(R.drawable.ic_no_image_found)
                .into(imageView)
        }
    }
}