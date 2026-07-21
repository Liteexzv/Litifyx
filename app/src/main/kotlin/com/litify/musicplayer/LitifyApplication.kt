package com.litify.musicplayer

import android.app.Application
import timber.log.Timber

class LitifyApplication : Application() {
    
    override fun onCreate() {
        super.onCreate()
        
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}