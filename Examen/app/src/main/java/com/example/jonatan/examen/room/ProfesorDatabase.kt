package com.example.jonatan.examen.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.jonatan.examen.models.Profesor

@Database(
    entities = [Profesor::class],
    version = 1,
    exportSchema = false
)
abstract class ProfesorDatabase: RoomDatabase() {
    abstract fun ProfesorDao(): ProfesorDatabaseDao
}