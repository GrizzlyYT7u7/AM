package com.example.jonatan.examen.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "profesor")
data class Profesor(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "nombre")
    val nombre: String,
    @ColumnInfo(name = "apellido")
    val apellido: String,
    @ColumnInfo(name = "telefono")
    val telefono: Int,
    @ColumnInfo(name = "email")
    val email: String,
)
