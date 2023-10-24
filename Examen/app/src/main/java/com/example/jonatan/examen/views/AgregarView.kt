package com.example.jonatan.examen.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jonatan.examen.models.Profesor
import com.example.jonatan.examen.viewmodel.ProfesorViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AgregarView(navController: NavController, viewModel: ProfesorViewModel) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Agregar Profesor",
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }, colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Regresar",
                            tint = Color.White
                        )

                    }
                }
            )
        }
    ) {
        ContentAgregarView(it, navController, viewModel)
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentAgregarView(
    it: PaddingValues,
    navController: NavController,
    viewModel: ProfesorViewModel
) {
    var nombre by remember {
        mutableStateOf("")
    }
    var apellido by remember {
        mutableStateOf("")
    }
    var telefonoInput by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }
    val telefono = telefonoInput.toIntOrNull() ?: 0

    Column(
        modifier = Modifier
            .padding(it)
            .padding(top = 30.dp)
            .fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        OutlinedTextField(
            value = nombre, onValueChange = { nombre = it },
            label = { Text(text = "nombre") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp)
        )
        OutlinedTextField(
            value = apellido, onValueChange = { apellido = it },
            label = { Text(text = "apellido") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp)
        )
        OutlinedTextField(
            value = telefonoInput,
            onValueChange = { telefonoInput = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text(text = "telefono") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp)
        )
        OutlinedTextField(
            value = email, onValueChange = { email = it },
            label = { Text(text = "email") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(bottom = 15.dp)
        )
        Button(onClick = {
            val profe =
                Profesor(nombre = nombre, apellido = apellido, telefono = telefono, email = email)

            viewModel.postProfesor(profe)
            navController.popBackStack()
        }) {
            Text(text = "Agregar")
        }
    }
}