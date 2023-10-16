package com.example.apuntsclase.Screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.example.apuntsclase.R

class SecondScreen : ComponentActivity() {

    val BackButton by lazy { findViewById<ImageButton>(R.id.back_button)}
    val SecondScreenText by lazy { findViewById<TextView>(R.id.second_screen_text)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_screen)
        SecondScreenText.text = intent.getStringExtra("Texto")

        BackButton.setOnClickListener{
            finish()
        }
    }
}