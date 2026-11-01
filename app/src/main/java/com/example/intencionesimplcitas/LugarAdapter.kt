package com.example.intencionesimplcitas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.intencionesimplcitas.R

class LugarAdapter(
    private val listaLugares: List<Lugar>,
    private val onItemClick: (Lugar) -> Unit
) : RecyclerView.Adapter<LugarAdapter.LugarViewHolder>() {

    class LugarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgLugar: ImageView = itemView.findViewById(R.id.imgLugar)
        val textNombre: TextView = itemView.findViewById(R.id.textNombreLugar)
        val textDesc: TextView = itemView.findViewById(R.id.textDescLugar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LugarViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_lugar, parent, false)
        return LugarViewHolder(view)
    }

    override fun onBindViewHolder(holder: LugarViewHolder, position: Int) {
        val lugar = listaLugares[position]
        holder.textNombre.text = lugar.nombre
        holder.textDesc.text = lugar.descripcion
        holder.imgLugar.setImageResource(lugar.imagen)

        // Configurar el evento de clic en el ítem completo
        holder.itemView.setOnClickListener {
            onItemClick(lugar)
        }
    }

    override fun getItemCount(): Int = listaLugares.size
}