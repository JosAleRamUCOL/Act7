package com.example.prac1_listado

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val data = ArrayList<AlumnosClass>()
        data.add(AlumnosClass(
            "Jose","20191086","correo1@ucol.mx","https://static.vecteezy.com/system/resources/previews/000/551/599/original/user-icon-vector.jpg"
        ))
        data.add(AlumnosClass(
            "Juan","20191087","correo2@ucol.mx","https://static.vecteezy.com/system/resources/previews/000/551/599/original/user-icon-vector.jpg"
        ))
        data.add(AlumnosClass(
            "Pedro","20191088","correo3@ucol.mx","https://static.vecteezy.com/system/resources/previews/000/551/599/original/user-icon-vector.jpg"
        ))
        data.add(AlumnosClass(
            "Maria","20191089","correo4@ucol.mx","https://static.vecteezy.com/system/resources/previews/000/551/599/original/user-icon-vector.jpg"
        ))
        data.add(AlumnosClass(
            "Luis","20191090","correo5@ucol.mx","https://static.vecteezy.com/system/resources/previews/000/551/599/original/user-icon-vector.jpg"
        ))
        data.add(AlumnosClass(
            "Alexa","20191091","correo6@ucol.mx","https://static.vecteezy.com/system/resources/previews/000/551/599/original/user-icon-vector.jpg"
        ))
        data.add(AlumnosClass(
            "Ana","20191092","correo7@ucol.mx","https://static.vecteezy.com/system/resources/previews/000/551/599/original/user-icon-vector.jpg"
        ))

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerAlumnos)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = AlumnosAdapter(this,data)
        recyclerView.adapter = adapter

        val bt_agregar = findViewById<FloatingActionButton>(R.id.bt_agregar)
        bt_agregar.setOnClickListener {
            val intento1 = Intent(this, MainActivityNuevo::class.java)
            startActivity(intento1)
        }

        val parExtra = intent.extras
        val msje = parExtra?.getString("mensaje")
        val nombre = parExtra?.getString("nombre")
        val cuenta = parExtra?.getString("cuenta")
        val correo = parExtra?.getString("correo")
        val imagen = parExtra?.getString("imagen")
        if (msje == "Nuevo") {
            val insertedIndex: Int = data.count()
            data.add(AlumnosClass(nombre.toString(), cuenta.toString(), correo.toString(), imagen.toString()))
            adapter.notifyItemInserted(insertedIndex)
        }



    }

}