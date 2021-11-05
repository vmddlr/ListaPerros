package com.example.konfioexam.data.adapter

import com.example.konfioexam.data.model.DogResponse
import java.io.Serializable

interface IDogListener : Serializable {

    fun clickCardView(entity: DogResponse)
}