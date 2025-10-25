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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ejemplo.clouded.R

data class Producto(
    val nombre: String,
    val precio: String,
    val imagen: Int
)

@Composable
fun CatalogScreen(
    categoria: String,
    navController: NavController
) {
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
            Producto("PRS SE Custom 24", "$850 USD", R.drawable.guitarra3),
            Producto("Marcus Miller Bass", "$720 USD", R.drawable.guitarra4)
        )
        "tecnología" -> listOf(
            Producto("Laptop ASUS TUF Gaming", "$1100 USD", R.drawable.tecnologia1),
            Producto("Gabinete Snake RGB", "$180 USD", R.drawable.tecnologia2),
            Producto("Mouse Logitech RGB", "$60 USD", R.drawable.tecnologia3),
            Producto("Teclado Mecánico RGB", "$90 USD", R.drawable.tecnologia4)
        )
        "hogar" -> listOf(
            Producto("Set de cuchillos acero inoxidable", "$75 USD", R.drawable.hogar1),
            Producto("Juego de platos blancos", "$40 USD", R.drawable.hogar2),
            Producto("Vasos de vidrio (x6)", "$25 USD", R.drawable.hogar3)
        )
        "accesorios" -> listOf(
            Producto("Bufanda verde cuadros", "$25 USD", R.drawable.accesorios),
            Producto("Reloj Rip Curl OceanTech", "$120 USD", R.drawable.accesorio3)
        )
        else -> emptyList()
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.fondonegro),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0x99000000))
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // 🔙 Botón Volver
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = { navController.popBackStack() },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                ) {
                    Text("Volver", color = Color.Black)
                }
            }

            Text(
                text = categoria,
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(8.dp)
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 12.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(productos) { producto ->
                    AnimatedVisibility(visible = true, enter = fadeIn()) {
                        ProductoCard(
                            producto = producto,
                            onClick = {
                                // 🧭 Navega al detalle del producto
                                val precioLimpio = producto.precio.replace("$", "").replace("USD", "").trim()
                                navController.navigate(
                                    "detalle/${producto.nombre}/${precioLimpio}/${producto.imagen}"
                                )
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ProductoCard(producto: Producto, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(10.dp)
        ) {
            Image(
                painter = painterResource(id = producto.imagen),
                contentDescription = producto.nombre,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(producto.nombre, fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Text(producto.precio, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
        }
    }
}


