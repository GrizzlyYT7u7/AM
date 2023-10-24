package com.example.jonatan.examen.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jonatan.examen.viewmodel.ProfesorViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetalleView(viewModel: ProfesorViewModel, id: Int) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Detalle", color = Color.White, fontWeight = FontWeight.Bold)
                },

                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    ) {
        ContentDetalleView(it, viewModel, id)
    }
}

@Composable
fun ContentDetalleView(it: PaddingValues, viewModel: ProfesorViewModel, id: Int) {

    val profe by viewModel.getProfesor(id).collectAsState(initial = null)

    Column(modifier = Modifier.padding(it)) {


        Box(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            Column {
                Text(profe?.nombre ?: "")
                Text(profe?.apellido ?: "")
                Text((profe?.telefono ?: "").toString())
                Text(profe?.email ?: "")
            }

        }
    }
}

