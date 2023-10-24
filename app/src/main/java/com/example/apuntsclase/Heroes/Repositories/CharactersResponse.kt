package com.example.apuntsclase.Heroes.Repositories

import com.example.apuntsclase.Heroes.HeroData
import com.google.gson.annotations.SerializedName

data class CharactersResponse(val code: Int, @SerializedName("data") val charactersData: CharactersResponseData)
data class CharactersResponseData(val code: Int, val count:Int, val total:Int, @SerializedName("results") val heroList: MutableList<HeroData> )
