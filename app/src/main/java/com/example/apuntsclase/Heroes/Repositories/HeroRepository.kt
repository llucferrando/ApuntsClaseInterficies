package com.example.apuntsclase.Heroes.Repositories

import com.example.apuntsclase.Heroes.HeroData

interface HeroRepository {
    suspend fun GetHeroes(): MutableList<HeroData>
}