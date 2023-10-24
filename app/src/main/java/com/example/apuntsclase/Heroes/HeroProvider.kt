package com.example.apuntsclase.Heroes

import com.example.apuntsclase.Heroes.Repositories.HeroRepository

class HeroProvider (val repository: HeroRepository) {

    suspend fun GetAllHeroes() : MutableList<HeroData>{
        return repository.GetHeroes()
    }
}