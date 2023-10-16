package com.example.apuntsclase.Screens

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.example.apuntsclase.R
import com.example.apuntsclase.Utils.Shared

class MainActivity : ComponentActivity() {

    val changeScreenBt by lazy {findViewById<Button>(R.id.change_screen_bt)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_screen)

        changeScreenBt.setOnClickListener{
            val newIntent = Intent(this, SecondScreen::class.java)
            this.startActivity(newIntent)

        }
    }
}


