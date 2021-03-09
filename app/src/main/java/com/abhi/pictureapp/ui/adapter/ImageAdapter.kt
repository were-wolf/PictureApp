package com.abhi.pictureapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abhi.pictureapp.R
import com.abhi.pictureapp.data.model.ImageDataModel
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.row_image.view.*

// image adapter for home page

class ImageAdapter(val imageList: ArrayList<ImageDataModel>, private val clickListener: (Int) -> Unit) :
    RecyclerView.Adapter<ImageViewHolder>() {

    private val options: RequestOptions? = RequestOptions()
        .centerCrop()
        .placeholder(R.drawable.bg_splash_launcher)
        .diskCacheStrategy(com.bumptech.glide.load.engine.DiskCacheStrategy.ALL)
        .priority(com.bumptech.glide.Priority.HIGH)

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ImageViewHolder {

        return ImageViewHolder(
            LayoutInflater.from(
                parent.context
            ).inflate(R.layout.row_image, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        if (options != null) {
            Glide.with(holder.imgPreview.context)
                .load(imageList[position].url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .apply(options)
                .into(holder.imgPreview)
        }

        holder.imgPreview.setOnClickListener {
            clickListener(position)
        }
    }

    override fun getItemCount(): Int {
        return imageList.size
    }
}

class ImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val imgPreview = view.imgPreview
}