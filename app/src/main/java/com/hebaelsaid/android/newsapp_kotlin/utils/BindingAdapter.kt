package com.hebaelsaid.android.newsapp_kotlin.utils

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target


@BindingAdapter("app:bindImgUrl", "app:bindProgressItem","app:bindImgWidth", "app:bindImgHeight")
fun setGlideImageUrl(
    image: ImageView,
    url: String?,
    progressBar: ProgressBar?,
    width: Int?,
    height: Int?
) {
    if (width != null && height != null) {
        Glide.with(image.context)
            .load(url)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    progressBar?.visibility = View.GONE
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    progressBar?.visibility = View.GONE
                    return false
                }
            }).into(image)
    }else{
        progressBar?.visibility = View.GONE
    }
}

/*
@BindingAdapter("app:bindImgWidth", "app:bindImgHeight")
fun setImageRatio(image: ImageView, width: Int?, height: Int?) {
    if (width != null && height != null) {
        image.maxWidth = width
        image.maxHeight = height
    }
}*/
