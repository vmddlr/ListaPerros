package com.example.konfioexam.data.repository

import androidx.lifecycle.LiveData
import com.example.konfioexam.data.model.DogResponse
import com.example.konfioexam.data.network.service.DogService
import com.example.konfioexam.data.room.RoomRepository
import javax.inject.Inject

class DogRepository @Inject constructor(
    private var service: DogService,
    private var room: RoomRepository
) {

    suspend fun getAllDogsRepository(): List<DogResponse> {
        val dataDB = room.getAllSelectRepository()

        val list =
            if (dataDB.isEmpty()) {
                service.getAllDogService()
            } else {
                room.getAllSelectRepository()
            }

        return list
    }
}