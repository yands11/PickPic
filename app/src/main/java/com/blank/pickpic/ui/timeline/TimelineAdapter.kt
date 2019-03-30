package com.blank.pickpic.ui.timeline

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.blank.pickpic.data.Photo
import com.blank.pickpic.databinding.HolderPhotoBinding


class TimelineAdapter(
    private val lifecycleOwner: LifecycleOwner
) : RecyclerView.Adapter<PhotoViewHolder>() {

    private var photos: List<Photo> = emptyList()

    override fun getItemCount(): Int = photos.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder =
        PhotoViewHolder(
            binding = HolderPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            lifecycleOwner = lifecycleOwner
        )

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.onBind(photos[position])
    }

    public fun handlePhotos(photos: List<Photo>) {
        this.photos = photos.orEmpty()
        notifyDataSetChanged()
    }
}

class PhotoViewHolder(
    private val binding: HolderPhotoBinding,
    private val lifecycleOwner: LifecycleOwner
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(photo: Photo) {
        binding.photo = photo
    }
}