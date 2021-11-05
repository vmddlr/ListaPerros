package com.example.konfioexam.data.model

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "Dogs", indices = [Index(value = ["dogName", "age"], unique = true)])
data class DogResponse(
    @PrimaryKey(autoGenerate = true) var id: Int? = null,
    @SerializedName("dogName") var dogName: String,
    @SerializedName("description") var description: String,
    @SerializedName("age") var age: Int,
    @SerializedName("image") var image: String
) : Serializable