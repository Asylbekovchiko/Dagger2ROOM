package com.example.testappforoptima.presentation

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.models.PhotosResponseItem
import com.example.testappforoptima.databinding.PhotoLayoutBinding

class MainAdapter(val clickOnPhoto: (photo: PhotosResponseItem) -> Unit) :
    RecyclerView.Adapter<MainAdapter.SmsVH>() {
    var list = emptyList<PhotosResponseItem>()

    @SuppressLint("NotifyDataSetChanged")
    fun setListSMS(list: List<PhotosResponseItem>) {
        this.list = list
        notifyDataSetChanged()
    }

    inner class SmsVH(val binding: PhotoLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("ResourceAsColor")
        fun onBind(photo: PhotosResponseItem) {
            binding.tvAuthor.text = photo.author
            Glide.with(binding.ivPhoto).load(photo.download_url).into(binding.ivPhoto)

            itemView.setOnClickListener {
                clickOnPhoto(photo)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SmsVH {
        val binding =
            PhotoLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SmsVH(binding)
    }

    override fun onBindViewHolder(holder: SmsVH, position: Int) {
        holder.onBind(list[position])


    }

    override fun getItemCount(): Int {
        return list.size
    }


}