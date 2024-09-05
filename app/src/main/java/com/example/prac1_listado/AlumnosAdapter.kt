package com.example.prac1_listado

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class AlumnosAdapter(private val context: Context, private val alumnosList:List<AlumnosClass>): RecyclerView.Adapter<AlumnosViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlumnosViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return AlumnosViewHolder(layoutInflater.inflate(R.layout.item_alumnos, parent, false))
    }

    override fun getItemCount(): Int = alumnosList.size

    override fun onBindViewHolder(holder: AlumnosViewHolder, position: Int) {
        val item = alumnosList[position]
        holder.render(item)
    }
}