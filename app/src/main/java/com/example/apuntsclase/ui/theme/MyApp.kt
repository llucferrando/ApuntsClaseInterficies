package com.example.apuntsclase.ui.theme

import android.app.Application

class MyApp : Application() {
    companion object{
       private lateinit var instance:MyApp
        public val Context: MyApp get() = instance
    }

    override fun onCreate(){
        super.onCreate()
        instance = this
    }

}