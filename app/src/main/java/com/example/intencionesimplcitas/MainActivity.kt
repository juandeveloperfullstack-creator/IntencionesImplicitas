//package com.example.intencionesimplcitas
//
//import android.os.Bundle
//import androidx.appcompat.app.AppCompatActivity
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//
//class MainActivity : AppCompatActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        // 1. Crear la lista de strings con nombres de personas
//        val nombresList = listOf(
//            "Carlos Pérez",
//            "María Gómez",
//            "Juan Rodríguez",
//            "Ana María Torres",
//            "Luis Fernando Díaz",
//            "Sofía Morales",
//            "Andrés Felipe Castro",
//            "Valentina Rojas"
//        )
//
//        // 2. Encontrar el RecyclerView en el layout
//        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewPersonas)
//
//        // 3. Configurar el LayoutManager para que sea vertical[cite: 17]
//        recyclerView.layoutManager = LinearLayoutManager(this)
//
//        // 4. Asignar el Adapter con la lista de datos[cite: 17]
//        recyclerView.adapter = PersonaAdapter(nombresList)
//    }
//}

// EJERCICIO 2

//package com.example.intencionesimplcitas
//
//import android.os.Bundle
//import androidx.appcompat.app.AppCompatActivity
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import com.example.intencionesimplcitas.R
//
//class MainActivity : AppCompatActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        // 1. Crear la lista de productos con nombre e imagen de drawable
//        // (Asegúrate de cambiar R.drawable.nombre_de_tu_imagen por tus recursos reales)
//        val productosList = listOf(
//            Producto("Laptop Gamer", R.drawable.img_laptop),
//            Producto("Smartphone Pro", R.drawable.img_smartphone),
//            Producto("Auriculares Inalámbricos", R.drawable.img_auriculares),
//            Producto("Smartwatch Deportivo", R.drawable.img_smartwatch),
//            Producto("Teclado Mecánico RGB", R.drawable.img_teclado)
//        )
//
//        // 2. Encontrar el RecyclerView
//        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewPersonas) // Puedes mantener o cambiar el ID en activity_main.xml si gustas
//
//        // 3. Configurar el LayoutManager
//        recyclerView.layoutManager = LinearLayoutManager(this)
//
//        // 4. Asignar el adaptador
//        recyclerView.adapter = ProductoAdapter(productosList)
//    }
//}

//EJERCICIO 3

//package com.example.intencionesimplcitas
//
//import android.content.Intent
//import android.os.Bundle
//import androidx.appcompat.app.AppCompatActivity
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import com.example.intencionesimplcitas.R
//
//class MainActivity : AppCompatActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        val lugaresList = listOf(
//            Lugar("Popayán Histórica", "Hermosa ciudad blanca con una arquitectura colonial maravillosa e iglesias emblemáticas.", R.drawable.img_laptop),
//            Lugar("Morro de Tulcán", "Sitio arqueológico e histórico ubicado en el corazón de la ciudad con una vista panorámica excelente.", R.drawable.img_smartphone),
//            Lugar("Puente del Humilladero", "Imponente puente de ladrillo construido en el siglo XIX para conectar el centro con el barrio Bolívar.", R.drawable.img_auriculares),
//            Lugar("Termales de Coconuco", "Hermosos paisajes naturales ideales para el descanso y disfrutar de aguas termales volcánicas.", R.drawable.img_smartwatch)
//        )
//
//        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewPersonas)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//
//        // Asignar el adaptador y programar el evento de clic[cite: 18]
//        recyclerView.adapter = LugarAdapter(lugaresList) { lugar ->
//            val intent = Intent(this, DetalleLugarActivity::class.java).apply {
//                putExtra("EXTRA_NOMBRE", lugar.nombre)
//                putExtra("EXTRA_DESC", lugar.descripcion)
//                putExtra("EXTRA_IMAGEN", lugar.imagen)
//            }
//            startActivity(intent)
//        }
//    }
//}

//EJERCICIO 4

//package com.example.intencionesimplcitas
//
//import android.os.Bundle
//import android.widget.Button
//import android.widget.EditText
//import android.widget.Toast
//import androidx.appcompat.app.AppCompatActivity
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import com.example.intencionesimplcitas.R
//
//class MainActivity : AppCompatActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        val etNuevoItem = findViewById<EditText>(R.id.etNuevoItem)
//        val btnAgregar = findViewById<Button>(R.id.btnAgregar)
//        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewDinamico)
//
//        // 1. Crear una lista mutable inicial
//        val listaItems = mutableListOf("Elemento 1", "Elemento 2", "Elemento 3")
//
//        // 2. Configurar el adaptador con la acción del Toast al hacer clic
//        val adapter = ItemAdapter(listaItems) { textoSeleccionado ->
//            Toast.makeText(this, "Seleccionado: $textoSeleccionado", Toast.LENGTH_SHORT).show()
//        }
//
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        recyclerView.adapter = adapter
//
//        // 3. Programar el botón para agregar el texto del EditText a la lista
//        btnAgregar.setOnClickListener {
//            val nuevoTexto = etNuevoItem.text.toString().trim()
//            if (nuevoTexto.isNotEmpty()) {
//                listaItems.add(nuevoTexto) // Agregar a la lista
//                adapter.notifyItemInserted(listaItems.size - 1) // Notificar al adaptador
//                recyclerView.scrollToPosition(listaItems.size - 1) // Opcional: mover el scroll al final
//                etNuevoItem.text.clear() // Limpiar el campo de texto
//            } else {
//                Toast.makeText(this, "Por favor escribe un texto", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }
//}

//EJERCICIO 5

package com.example.intencionesimplcitas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.intencionesimplcitas.R

class MainActivity : AppCompatActivity() {

    private lateinit var textResultado: TextView

    // Registrar el contrato para recibir el resultado de ListaActivity
    private val launcher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val data = result.data
            val producto = data?.getSerializableExtra("PRODUCTO_SELECCIONADO") as? Producto
            if (producto != null) {
                // Mostrar el producto seleccionado en el TextView[cite: 18]
                textResultado.text = "Seleccionado: ${producto.nombre} - $${producto.precio}"
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnIrALista = findViewById<Button>(R.id.btnIrALista)
        val btnIrADashboard = findViewById<Button>(R.id.btnIrADashboard)
        textResultado = findViewById<TextView>(R.id.textResultado)

        btnIrALista.setOnClickListener {
            val intent = Intent(this, ListaActivity::class.java)
            launcher.launch(intent) // Lanzar la actividad esperando un resultado
        }

        btnIrADashboard.setOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
        }
    }
}