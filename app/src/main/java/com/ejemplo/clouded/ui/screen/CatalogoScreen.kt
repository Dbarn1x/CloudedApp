package com.ejemplo.clouded.ui.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ejemplo.clouded.R
import com.ejemplo.clouded.ui.theme.CloudedColors

data class Producto(val nombre: String, val precio: String, val imagen: Int)

@Composable
fun CatalogoScreen(categoria: String, navController: NavController) {
    val productos = when (categoria.lowercase()) {
        "calzado" -> listOf(
            Producto("Air Jordan 4 (Fire Red)", "$220 USD", R.drawable.jordan4firered),
            Producto("Air Jordan 4 “Fear”", "$240 USD", R.drawable.jordan4fear),
            Producto("Air Jordan 4 Pine Green", "$230 USD", R.drawable.jordan4pinegreen)
        )
        "ropa" -> listOf(
            Producto("Chaqueta de cuero negra", "$85 USD", R.drawable.ropa1),
            Producto("Camisa blanco & negro", "$55 USD", R.drawable.ropa2),
            Producto("Pantalón cargo negro", "$65 USD", R.drawable.ropa3)
        )
        "música" -> listOf(
            Producto("Stratocaster Negra", "$500 USD", R.drawable.guitarra1),
            Producto("Epiphone Les Paul Junior", "$450 USD", R.drawable.guitarra2),
            Producto("PRS SE Custom 24", "$850 USD", R.drawable.guitarra3)
        )
        else -> emptyList()
    }

    Box(Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.fondonegro),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Box(Modifier.fillMaxSize().background(CloudedColors.FondoTransparente))
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(Modifier.height(10.dp))
            Button(onClick = { navController.popBackStack() }) { Text("← Volver") }
            Text(categoria, color = CloudedColors.BlancoTexto, fontSize = 22.sp, fontWeight = FontWeight.Bold)
            LazyColumn(contentPadding = PaddingValues(12.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
                items(productos) { p ->
                    AnimatedVisibility(visible = true, enter = fadeIn()) {
                        ProductoCard(p) {
                            val precioLimpio = p.precio.replace("$", "").replace("USD", "").trim()
                            navController.navigate("detalle/${p.nombre}/${precioLimpio}/${p.imagen}")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ProductoCard(p: Producto, onClick: () -> Unit) {
    Card(modifier = Modifier.fillMaxWidth().clickable { onClick() }, elevation = CardDefaults.cardElevation(6.dp)) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(10.dp)) {
            Image(
                painter = painterResource(id = p.imagen),
                contentDescription = p.nombre,
                modifier = Modifier.fillMaxWidth().height(200.dp),
                contentScale = ContentScale.Crop
            )
            Text(p.nombre, fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Text(p.precio, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
        }
    }
}


