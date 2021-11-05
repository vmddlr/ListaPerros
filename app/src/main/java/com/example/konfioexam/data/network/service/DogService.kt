package com.example.konfioexam.data.network.service

import androidx.lifecycle.LiveData
import com.example.konfioexam.data.model.DogResponse
import com.example.konfioexam.data.network.api.DogApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DogService @Inject constructor(
    private val dogApi: DogApi
) {

    suspend fun getAllDogService(): List<DogResponse> {
        return withContext(Dispatchers.IO) {
            val response = dogApi.getAllDogsApi()
            response.body() ?: emptyList()
        }
    }
}