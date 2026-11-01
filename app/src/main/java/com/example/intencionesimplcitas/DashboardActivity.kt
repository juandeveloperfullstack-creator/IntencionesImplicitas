package com.example.intencionesimplcitas

import android.content.Intent
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class DashboardActivity : AppCompatActivity() {

    private lateinit var tvResultado: TextView

    private val contactoLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val uri: Uri? = result.data?.data
            if (uri != null) {
                val cursor: Cursor? = contentResolver.query(uri, null, null, null, null)
                if (cursor?.moveToFirst() == true) {
                    val nameIndex = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)
                    val nombre = cursor.getString(nameIndex)
                    tvResultado.text = "Contacto seleccionado (Ej 10): $nombre"
                    cursor.close()
                }
            }
        }
    }

    private val pdfLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val uri: Uri? = result.data?.data
            if (uri != null) {
                val intent = Intent(Intent.ACTION_VIEW).apply {
                    setDataAndType(uri, "application/pdf")
                    addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                }
                try {
                    startActivity(intent)
                } catch (_: Exception) {
                    Toast.makeText(this, "No hay aplicación para abrir PDF", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        tvResultado = findViewById(R.id.tvResultadoDashboard)

        // Llamar (Intent.ACTION_DIAL)
        findViewById<Button>(R.id.btnLlamar).setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:3001234567"))
            startActivity(intent)
        }

        // Correo (Intent.ACTION_SENDTO)
        findViewById<Button>(R.id.btnCorreo).setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:contacto@example.com")
                putExtra(Intent.EXTRA_SUBJECT, "Asunto de prueba")
                putExtra(Intent.EXTRA_TEXT, "Cuerpo del mensaje...")
            }
            startActivity(intent)
        }

        // Ej 8: Google Maps (Intent.ACTION_VIEW geo:)
        findViewById<Button>(R.id.btnMapa).setOnClickListener {
            val lat = 2.4419
            val lng = -76.6063
            val gmmIntentUri = Uri.parse("geo:$lat,$lng?q=$lat,$lng(Popayán)")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            startActivity(mapIntent)
        }

        // Ej 9: Compartir Texto (Intent.ACTION_SEND)
        findViewById<Button>(R.id.btnCompartir).setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, "¡Hola desde la app de intenciones implícitas (Ej 9)! ")
            }
            startActivity(Intent.createChooser(intent, "Compartir texto usando"))
        }

        // Ej 10: Seleccionar Contacto (ACTION_PICK)
        findViewById<Button>(R.id.btnContacto).setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI)
            contactoLauncher.launch(intent)
        }

        // Ej 11: Abrir Archivo PDF (ACTION_OPEN_DOCUMENT)
        findViewById<Button>(R.id.btnPdf).setOnClickListener {
            val intent = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
                addCategory(Intent.CATEGORY_OPENABLE)
                type = "application/pdf"
            }
            pdfLauncher.launch(intent)
        }

        // Ej 12: Página Web (Intent.ACTION_VIEW)
        findViewById<Button>(R.id.btnWeb).setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://developer.android.com"))
            startActivity(intent)
        }
    }
}
