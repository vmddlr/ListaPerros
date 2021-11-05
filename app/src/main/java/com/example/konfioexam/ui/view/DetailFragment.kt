package com.example.konfioexam.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.konfioexam.R
import com.example.konfioexam.data.model.DogResponse
import com.example.konfioexam.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        this.binding = FragmentDetailBinding.inflate(inflater, container, false)
        return this.binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val entity = arguments?.getSerializable("entity") as DogResponse

        this.binding.tvNameDog.text = entity.dogName
        this.binding.tvAge.text = "Ages: ${entity.age}"
        this.binding.tvDescription.text = entity.description

        Glide
            .with(this.requireContext())
            .load(entity.image)
            .transform(RoundedCorners(32))
            .into(this.binding.ivDog)

    }
}