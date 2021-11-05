package com.example.konfioexam.di

import android.content.Context
import androidx.room.Room
import com.example.konfioexam.data.network.api.DogApi
import com.example.konfioexam.data.room.AppDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit() =
        Retrofit.Builder()
            .baseUrl("https://jsonblob.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    @Singleton
    @Provides
    fun provideDogsService(retrofit: Retrofit) =
        retrofit.create(DogApi::class.java)

    //  Room
    @Singleton
    @Provides
    fun provideDataBase(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            AppDataBase::class.java,
            "APP_DataBase"
        ).build()


    @Singleton
    @Provides
    fun providerDao(db: AppDataBase) =
        db.appDao()

}