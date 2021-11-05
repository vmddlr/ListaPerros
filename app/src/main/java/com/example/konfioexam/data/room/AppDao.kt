package com.example.konfioexam.data.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.konfioexam.data.model.DogResponse

@Dao
interface AppDao {

    @Query("SELECT * FROM Dogs")
    suspend fun getAllSelect() : List<DogResponse>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(dogEntity: List<DogResponse>)
}