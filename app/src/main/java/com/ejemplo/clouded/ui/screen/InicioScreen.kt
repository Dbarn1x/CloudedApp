package com.ejemplo.clouded.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InicioScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Bienvenido a Clouded 🎶", fontSize = 24.sp)
            Spacer(modifier = Modifier.height(10.dp))
            Text("Has iniciado sesión correctamente.", fontSize = 16.sp)
        }
    }
}
