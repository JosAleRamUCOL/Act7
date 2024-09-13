package com.example.prac1_listado

import android.view.View
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl

class AlumnosViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val nombreSB = view.findViewById<TextView>(R.id.tvNombreSB)
    val cuentaSB = view.findViewById<TextView>(R.id.tvCuentaSB)
    val alumnoSB = view.findViewById<ImageView>(R.id.ivAlumnoSB)
    val menuSB = view.findViewById<TextView>(R.id.textViewOptions)

    fun render(alumnosModel: AlumnosClass) {
        nombreSB.text = alumnosModel.nombre
        cuentaSB.text = alumnosModel.cuenta
        menuSB.setOnClickListener {popupMenu(it)}
        Glide.with(alumnoSB.context).load(alumnosModel.imagen).into(alumnoSB)
    }

    private fun popupMenu(view: View) {
        val popupMenus = PopupMenu(view.context, view)
        popupMenus.inflate(R.menu.option_menu)
        popupMenus.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.m_editar -> {

                    Toast.makeText(view.context, "Editar", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.m_ver -> {
                    Toast.makeText(view.context, "Ver", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.m_eliminar -> {

                    Toast.makeText(view.context, "Eliminar", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> true
            }
        }
        popupMenus.show()
        val popup = PopupMenu::class.java.getDeclaredField("mPopup")
        popup.isAccessible = true
        val menu = popup.get(popupMenus)
        menu.javaClass.getDeclaredMethod("setForceShowIcon", Boolean::class.java).invoke(menu, true)
    }

}