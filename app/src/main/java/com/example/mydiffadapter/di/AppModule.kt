package com.example.mydiffadapter.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.mydiffadapter.data.DataManager
import com.example.mydiffadapter.utils.PREFS_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDataManager(preferences: SharedPreferences): DataManager = DataManager(preferences)

    @Provides
    @Singleton
    fun provideSharedPreference(context: Application): SharedPreferences {
        return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }
}