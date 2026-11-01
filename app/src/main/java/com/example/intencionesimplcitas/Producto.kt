package com.example.intencionesimplcitas

import java.io.Serializable

data class Producto(
    val nombre: String,
    val precio: Double,
    val imagen: Int = 0 // Valor por defecto para que no falle en los lugares donde no se use
) : Serializable