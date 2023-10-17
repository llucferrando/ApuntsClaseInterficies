package com.example.apuntsclase.Screens

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apuntsclase.Heroes.HeroAdapter
import com.example.apuntsclase.Heroes.HeroData
import com.example.apuntsclase.Heroes.HeroRepository
import com.example.apuntsclase.R
import com.example.apuntsclase.Utils.Shared

class MainActivity : ComponentActivity() {
    val table by lazy{findViewById<RecyclerView>(R.id.My_heros_app)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_screen)

        table.layoutManager = LinearLayoutManager(this)






        table.adapter = HeroAdapter(HeroRepository.GetAllHeroes())
    }
}


