package com.example.intencionesimplcitas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PersonaAdapter(private val listaPersonas: List<String>) :
    RecyclerView.Adapter<PersonaAdapter.PersonaViewHolder>() {

    // ViewHolder para contener la referencia del diseño de cada celda
    class PersonaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textNombre: TextView = itemView.findViewById(R.id.textNombrePersona)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_persona, parent, false)
        return PersonaViewHolder(view)
    }

    override fun onBindViewHolder(holder: PersonaViewHolder, position: Int) {
        holder.textNombre.text = listaPersonas[position]
    }

    override fun getItemCount(): Int {
        return listaPersonas.size
    }
}