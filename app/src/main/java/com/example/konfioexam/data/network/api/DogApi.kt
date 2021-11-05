package com.example.konfioexam.data.network.api

import com.example.konfioexam.data.model.DogResponse
import retrofit2.Response
import retrofit2.http.GET

interface DogApi {

    @GET("880188946124021760")
    suspend fun getAllDogsApi(): Response<List<DogResponse>>
}