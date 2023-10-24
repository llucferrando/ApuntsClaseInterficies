package com.example.apuntsclase.Heroes.Repositories

import com.example.apuntsclase.Heroes.HeroData

class HeroMockRepository : HeroRepository {
    companion object {
        private val heroesListHardcoded = mutableListOf(
            HeroData("Aquaman", "Pez"),
            HeroData("Superman", "Humano"),
            HeroData("Spiderman", "Araña"),
            HeroData("Thor", "Asgardiano"),
            HeroData("Batman", "Murcielago")
        )
    }
    override suspend fun GetHeroes(): MutableList<HeroData> {
        return heroesListHardcoded




    }
}