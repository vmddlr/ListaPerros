package com.example.konfioexam.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.konfioexam.data.model.DogResponse
import com.example.konfioexam.data.repository.DogRepository
import com.example.konfioexam.data.room.RoomRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val dogRepository: DogRepository,
    private var room: RoomRepository
) : ViewModel() {

    val listDogsViewModel = MutableLiveData<List<DogResponse>>()

    fun onCreateViewModel() {
        viewModelScope.launch {
            val dataDB = room.getAllSelectRepository()
            val listResponse = dogRepository.getAllDogsRepository()

            if (dataDB.isEmpty()) {
                room.insertRepository(listResponse)
            }

            listDogsViewModel.postValue(listResponse)
        }
    }
}