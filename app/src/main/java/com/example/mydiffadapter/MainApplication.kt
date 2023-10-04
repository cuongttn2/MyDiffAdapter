package com.example.mydiffadapter

import android.app.Application
import android.content.Context
import com.example.mydiffadapter.data.DataManager
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
open class MainApplication : Application() {
    @Inject
    lateinit var dataManager: DataManager

    companion object {
        lateinit var instance: MainApplication
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}