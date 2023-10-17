package com.example.apuntsclase.Heroes

class HeroRepository  {
    companion object{
       private val heroesListHardcoded = listOf(
            HeroData("Aquaman", "Pez"),
            HeroData("Superman", "Humano"),
            HeroData("Spiderman", "Araña"),
            HeroData("Thor", "Asgardiano"),
            HeroData("Batman", "Murcielago")
        )


        fun GetAllHeroes() : List<HeroData>  = heroesListHardcoded
    }

}