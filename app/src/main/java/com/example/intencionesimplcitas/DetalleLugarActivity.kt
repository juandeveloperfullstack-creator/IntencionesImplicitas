package com.example.intencionesimplcitas

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.intencionesimplcitas.R

class DetalleLugarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_lugar)

        val imgDetalle = findViewById<ImageView>(R.id.imgDetalle)
        val textNombre = findViewById<TextView>(R.id.textNombreDetalle)
        val textDesc = findViewById<TextView>(R.id.textDescDetalle)

        // Recibir los datos enviados por el Intent desde MainActivity
        val nombre = intent.getStringExtra("EXTRA_NOMBRE")
        val descripcion = intent.getStringExtra("EXTRA_DESC")
        val imagen = intent.getIntExtra("EXTRA_IMAGEN", 0)

        // Mostrar los datos en los componentes de la vista
        textNombre.text = nombre
        textDesc.text = descripcion
        if (imagen != 0) {
            imgDetalle.setImageResource(imagen)
        }
    }
}