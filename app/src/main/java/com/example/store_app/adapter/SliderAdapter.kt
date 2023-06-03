package com.example.store_app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.store_app.R
import com.example.store_app.data_class.ImageSlider
import com.makeramen.roundedimageview.RoundedImageView

class SliderAdapter(
    private val listImage: ArrayList<ImageSlider>
): RecyclerView.Adapter<SliderAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val imageSlider = view.findViewById<RoundedImageView>(R.id.id_image_slider_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.image_slider_container, parent, false)
    )

    override fun getItemCount() = this.listImage.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imageSlider.setImageResource(listImage[position].image)
    }
}

