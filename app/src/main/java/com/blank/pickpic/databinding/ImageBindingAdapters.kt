package com.blank.pickpic.databinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

@BindingAdapter("image_url")
fun loadImage(view: ImageView, url: String?) {
    val reqOptions = RequestOptions()
        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
        .centerCrop()

    Glide.with(view.context)
        .load(url)
        .apply(reqOptions)
        .into(view)
}
