package com.example.konfioexam.data.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.konfioexam.data.model.DogResponse
import com.example.konfioexam.databinding.ItemDetailDogLayoutBinding
import javax.inject.Inject


class DogAdapter @Inject constructor(
    private val dogsList: List<DogResponse>,
    private val listener: IDogListener
) : RecyclerView.Adapter<DogAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        this.context = parent.context

        val binding = ItemDetailDogLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val entity = this.dogsList[position]

        with(holder) {
            Glide
                .with(this@DogAdapter.context)
                .load(entity.image)
                .transform(RoundedCorners(32))
                .into(this.binding.ivDog)

            binding.tvDogName.text = entity.dogName
            binding.tvDescription.text = entity.description
            binding.tvYears.text = "Almost ${entity.age.toString()} years"

            binding.cardView.setOnClickListener {
                this@DogAdapter.listener.clickCardView(entity)
            }
        }
    }

    override fun getItemCount(): Int = this.dogsList.size

    inner class ViewHolder(val binding: ItemDetailDogLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)
}