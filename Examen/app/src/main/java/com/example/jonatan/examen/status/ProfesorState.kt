package com.example.jonatan.examen.status

import com.example.jonatan.examen.models.Profesor

data class ProfesorState(
    val listaProfesor: List<Profesor> = emptyList()
)
