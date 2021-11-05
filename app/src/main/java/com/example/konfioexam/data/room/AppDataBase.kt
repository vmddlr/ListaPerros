package com.example.konfioexam.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.konfioexam.data.model.DogResponse

@Database(
    entities = [DogResponse::class],
    version = 1
)
abstract class AppDataBase : RoomDatabase() {

    abstract fun appDao(): AppDao
}