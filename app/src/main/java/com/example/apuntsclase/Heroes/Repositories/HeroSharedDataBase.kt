package com.example.apuntsclase.Heroes.Repositories

import com.example.apuntsclase.Heroes.HeroData
import com.example.apuntsclase.Utils.Shared

class HeroSharedDataBase: HeroRepository {
    override suspend fun GetHeroes(): MutableList<HeroData> {
        return Shared.Heroes
    }
}