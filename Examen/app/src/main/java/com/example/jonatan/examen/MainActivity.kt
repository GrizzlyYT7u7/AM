package com.example.jonatan.examen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.room.Room
import com.example.jonatan.examen.navigation.NavManager
import com.example.jonatan.examen.room.ProfesorDatabase
import com.example.jonatan.examen.viewmodel.ProfesorViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.primary
            ) {
                val database = Room.databaseBuilder(this, ProfesorDatabase::class.java, "profesor")
                    .allowMainThreadQueries().build()
                val dao = database.ProfesorDao()
                val viewModelPro = ProfesorViewModel(dao)
                NavManager(viewModel = viewModelPro)

            }
        }
    }
}

