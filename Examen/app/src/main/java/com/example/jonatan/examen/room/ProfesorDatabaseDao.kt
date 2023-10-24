package com.example.jonatan.examen.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.jonatan.examen.models.Profesor
import kotlinx.coroutines.flow.Flow

@Dao
interface ProfesorDatabaseDao {

    @Query("SELECT * FROM profesor")
    fun getProfesores(): Flow<List<Profesor>>

    @Query("SELECT * FROM profesor WHERE id = :id")
    fun getProfesor(id: Int): Flow<Profesor>

    @Insert
    suspend fun postProfesor(profesor: Profesor)
}