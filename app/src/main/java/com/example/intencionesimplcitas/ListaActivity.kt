package com.example.intencionesimplcitas

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.intencionesimplcitas.R

class ListaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewProductos)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Recibir la lista enviada desde MainActivity (o usar una predefinida si prefieres)
        val listaProductos = listOf(
            Producto("Laptop Gamer", 1500.0),
            Producto("Smartphone Pro", 800.0),
            Producto("Auriculares Inalámbricos", 150.0),
            Producto("Smartwatch Deportivo", 250.0)
        )

        recyclerView.adapter = ProductoSelectAdapter(listaProductos) { productoSeleccionado ->
            // Al seleccionar un producto, lo devolvemos a MainActivity
            val intentRetorno = Intent().apply {
                putExtra("PRODUCTO_SELECCIONADO", productoSeleccionado)
            }
            setResult(RESULT_OK, intentRetorno)
            finish() // Cierra esta actividad y regresa a MainActivity
        }
    }
}