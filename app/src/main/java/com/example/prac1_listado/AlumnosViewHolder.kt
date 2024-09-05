package com.example.prac1_listado

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl

class AlumnosViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val nombreSB = view.findViewById<TextView>(R.id.tvNombreSB)
    val cuentaSB = view.findViewById<TextView>(R.id.tvCuentaSB)
    val alumnoSB = view.findViewById<ImageView>(R.id.ivAlumnoSB)

    fun render(alumnosModel: AlumnosClass) {
        nombreSB.text = alumnosModel.nombre
        cuentaSB.text = alumnosModel.cuenta
        Glide.with(alumnoSB.context).load(alumnosModel.imagen).into(alumnoSB)
    }

}