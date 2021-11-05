package com.example.konfioexam.data.room

import androidx.lifecycle.LiveData
import com.example.konfioexam.data.model.DogResponse
import javax.inject.Inject

class RoomRepository @Inject constructor(
    private val appDao: AppDao
) {

    suspend fun getAllSelectRepository(): List<DogResponse> {
        return this.appDao.getAllSelect()
    }

    suspend fun insertRepository(list: List<DogResponse>) {
        this.appDao.insert(list)
    }
}