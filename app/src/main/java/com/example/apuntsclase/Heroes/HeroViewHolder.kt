package com.example.apuntsclase.Heroes

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.apuntsclase.R

class HeroViewHolder(view:View) : ViewHolder(view) {

    val name by lazy { view.findViewById<TextView>(R.id.hero_cell_title) }
    val descrip by lazy { view.findViewById<TextView>(R.id.hero_cell_description) }

    fun SetUpWith(hero: HeroData){
        name.text = hero.name
        descrip.text = hero.description

    }

}