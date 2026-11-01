package com.example.intencionesimplcitas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.intencionesimplcitas.R

class ItemAdapter(
    private val listaItems: MutableList<String>,
    private val onItemClick: (String) -> Unit
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.textItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_simple, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val texto = listaItems[position]
        holder.textView.text = texto

        // Configurar el evento de clic para cada elemento
        holder.itemView.setOnClickListener {
            onItemClick(texto)
        }
    }

    override fun getItemCount(): Int = listaItems.size
}