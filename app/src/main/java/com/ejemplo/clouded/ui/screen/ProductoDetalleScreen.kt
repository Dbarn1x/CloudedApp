package com.ejemplo.clouded.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ejemplo.clouded.R

@Composable
fun ProductoDetalleScreen(
    nombre: String,
    precio: Double,
    imagen: Int,
    navController: NavController
) {
    var cantidad by remember { mutableStateOf(0) }
    val total = precio * cantidad

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0D1117))
            .padding(16.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = imagen),
                contentDescription = nombre,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(30.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = { if (cantidad > 0) cantidad-- },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD50000)),
                    modifier = Modifier.size(50.dp)
                ) {
                    Text("-", color = Color.White, fontSize = 22.sp)
                }

                Box(
                    modifier = Modifier
                        .width(80.dp)
                        .height(45.dp)
                        .background(Color.White),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = cantidad.toString(),
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                }

                Button(
                    onClick = { cantidad++ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00C853)),
                    modifier = Modifier.size(50.dp)
                ) {
                    Text("+", color = Color.White, fontSize = 22.sp)
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Precio: $${precio} USD",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Total: $${"%.2f".format(total)} USD",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(25.dp))

            Button(
                onClick = {
                    if (cantidad > 0) {
                        navController.navigate("pago_simulado/${nombre}/${"%.2f".format(total)}")
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00C853)),
                modifier = Modifier
                    .width(220.dp)
                    .height(50.dp)
            ) {
                Text(
                    text = "PAGAR AHORA",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = { navController.popBackStack() },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                modifier = Modifier
                    .width(220.dp)
                    .height(50.dp)
            ) {
                Text("VOLVER", color = Color.Black, fontWeight = FontWeight.Bold)
            }
        }
    }
}

