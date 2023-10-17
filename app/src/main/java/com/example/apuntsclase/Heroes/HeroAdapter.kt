package com.example.apuntsclase.Heroes

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apuntsclase.R


class HeroAdapter(private val heroList: List<HeroData>) : RecyclerView.Adapter<HeroViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return HeroViewHolder(layoutInflater.inflate(R.layout.herocell,parent,false))

    }

    override fun getItemCount(): Int {
        return heroList.size
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        holder.SetUpWith(heroList[position])
    }

}