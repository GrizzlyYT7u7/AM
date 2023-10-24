package com.example.jonatan.examen.viewmodel

import androidx.compose.runtime.getValue
import com.example.jonatan.examen.room.ProfesorDatabaseDao
import com.example.jonatan.examen.status.ProfesorState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jonatan.examen.models.Profesor
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class ProfesorViewModel(private val dao: ProfesorDatabaseDao) : ViewModel() {

    var state by mutableStateOf(ProfesorState())
        private set

    init {
        viewModelScope.launch {
            dao.getProfesores().collectLatest {
                state = state.copy(listaProfesor = it)
            }
        }
    }

    fun postProfesor(profesor: Profesor) = viewModelScope.launch {
        dao.postProfesor(profesor)
    }

    fun getProfesor(id: Int): Flow<Profesor> {
        return dao.getProfesor(id)
    }

}