package com.example.prac1_listado

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivityNuevo : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_nuevo)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val txt_nombre = findViewById<EditText>(R.id.txtNombre)
        val txt_cuenta = findViewById<EditText>(R.id.txtCuenta)
        val txt_correo = findViewById<EditText>(R.id.txtCorreo)
        val txt_image = findViewById<EditText>(R.id.txtImage)
        val btn_guardar = findViewById<Button>(R.id.btnGuardar)

        btn_guardar.setOnClickListener {
            val intento2 = Intent(this, MainActivity::class.java)
            intento2.putExtra("mensaje", "Nuevo")
            intento2.putExtra("nombre", txt_nombre.text.toString())
            intento2.putExtra("cuenta", txt_cuenta.text.toString())
            intento2.putExtra("correo", txt_correo.text.toString())
            intento2.putExtra("imagen", txt_image.text.toString())
            startActivity(intento2)
        }
    }
}