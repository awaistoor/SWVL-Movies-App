package com.example.swvlmoviesapp

import android.app.Application

class SWVLMoviesApp : Application() {

    init {
        instance = this
    }
    /// Application instance
    companion object {
        private var instance: SWVLMoviesApp? = null
        fun getInstance(): SWVLMoviesApp {
            synchronized(SWVLMoviesApp::class.java) {
                if (instance == null)
                    instance = SWVLMoviesApp()
            }
            return instance!!
        }
    }
}