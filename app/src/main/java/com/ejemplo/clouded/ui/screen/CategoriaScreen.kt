package com.ejemplo.clouded.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ejemplo.clouded.R

@Composable
fun CategoriaScreen(nombreUsuario: String, onCategoriaClick: (String) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // 🔹 Fondo de pantalla
        Image(
            painter = painterResource(id = R.drawable.fondonegro),
            contentDescription = "Fondo",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // 🔹 Contenido principal
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 80.dp)
        ) {
            Text(
                text = "Bienvenido $nombreUsuario",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Indícanos lo que buscas",
                color = Color.White,
                fontSize = 16.sp,
                modifier = Modifier.padding(bottom = 32.dp)
            )

            // 🔸 Botones de categorías
            Column(
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
                    CategoriaBoton("Calzado") { onCategoriaClick("calzado") }
                    CategoriaBoton("Música") { onCategoriaClick("musica") }
                }
                Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
                    CategoriaBoton("Ropa") { onCategoriaClick("ropa") }
                    CategoriaBoton("Accesorios") { onCategoriaClick("accesorios") }
                }
                Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
                    CategoriaBoton("Tecnología") { onCategoriaClick("tecnologia") }
                    CategoriaBoton("Hogar") { onCategoriaClick("hogar") }
                }
            }
        }
    }
}

@Composable
fun CategoriaBoton(titulo: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .width(150.dp)
            .height(60.dp)
            .background(Color.White, shape = RoundedCornerShape(10.dp))
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = titulo,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            textAlign = TextAlign.Center,
            fontSize = 18.sp
        )
    }
}
