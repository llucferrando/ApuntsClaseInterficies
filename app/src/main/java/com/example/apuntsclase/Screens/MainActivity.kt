package com.example.apuntsclase.Screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apuntsclase.Heroes.HeroAdapter
import com.example.apuntsclase.Heroes.HeroData
import com.example.apuntsclase.Heroes.HeroProvider
import com.example.apuntsclase.Heroes.Repositories.HeroApiService
import com.example.apuntsclase.Heroes.Repositories.HeroMockRepository
import com.example.apuntsclase.Heroes.Repositories.HeroSharedDataBase
import com.example.apuntsclase.R
import com.example.apuntsclase.Utils.Shared
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    val table by lazy{findViewById<RecyclerView>(R.id.My_heros_app)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_screen)

        table.layoutManager = LinearLayoutManager(this)


        val repository = HeroApiService()


        val provider = HeroProvider(repository)


        CoroutineScope(Dispatchers.IO).launch {
            val heroes = provider.GetAllHeroes()
            CoroutineScope(Dispatchers.Main).launch {
                table.adapter = HeroAdapter(heroes)
            }
        }
    }
}


