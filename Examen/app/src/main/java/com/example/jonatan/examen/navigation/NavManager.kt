package com.example.jonatan.examen.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jonatan.examen.viewmodel.ProfesorViewModel
import com.example.jonatan.examen.views.AgregarView
import com.example.jonatan.examen.views.InicioView
import com.example.jonatan.examen.views.DetalleView

@Composable
fun NavManager(viewModel: ProfesorViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "inicio") {
        composable("inicio") {
            InicioView(navController, viewModel)
        }

        composable("agregar") {
            AgregarView(navController, viewModel)
        }

        composable("detalle/{id}") {
            val id = it.arguments?.getInt("id") ?: return@composable

            DetalleView(viewModel, id)
        }
    }
}
