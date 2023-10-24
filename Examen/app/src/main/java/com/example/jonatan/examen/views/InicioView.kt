package com.example.jonatan.examen.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jonatan.examen.viewmodel.ProfesorViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InicioView(navController: NavController, viewModel: ProfesorViewModel) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Inicio", color = Color.White, fontWeight = FontWeight.Bold)
                },

                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("agregar") },
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = Color.White
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Agregar")
            }
        }
    ) {
        ContentInicioView(it, navController, viewModel)
    }
}


@Composable
fun ContentInicioView(
    it: PaddingValues,
    navController: NavController,
    viewModel: ProfesorViewModel
) {
    val state = viewModel.state

    Column(modifier = Modifier.padding(it)) {
        LazyColumn() {
            items(state.listaProfesor) {
                Box(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .padding(12.dp)
                            .fillMaxWidth()
                    ) {
                        Text(text = it.nombre)
                        Text(text = it.apellido)
                        IconButton(onClick = { navController.navigate("detalle/${it.id}") }) {
                            Icon(
                                imageVector = Icons.Default.ArrowForward,
                                contentDescription = "Detalle"
                            )
                        }
                    }
                }
            }
        }
    }
}

