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
import kotlinx.coroutines.delay

@Composable
fun PagoSimuladoScreen(nombre: String, total: String, navController: NavController) {
    var cargando by remember { mutableStateOf(false) }

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

        if (!cargando) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize().padding(16.dp)
            ) {
                Text(
                    "Webpay",
                    color = Color.White,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(24.dp))
                Text("Producto: $nombre", color = Color.LightGray, fontSize = 18.sp)
                Text("Total: $${total} USD", color = Color.White, fontSize = 20.sp)
                Spacer(modifier = Modifier.height(40.dp))
                Button(
                    onClick = { cargando = true },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00C853)),
                    modifier = Modifier.width(220.dp).height(50.dp)
                ) {
                    Text("Confirmar pago", fontSize = 18.sp, color = Color.White)
                }
                Spacer(modifier = Modifier.height(20.dp))
                Button(
                    onClick = { navController.popBackStack() },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                    modifier = Modifier.width(220.dp).height(50.dp)
                ) {
                    Text("Cancelar", color = Color.Black)
                }
            }
        } else {
            // Animación de carga simulando proceso de pago
            LaunchedEffect(Unit) {
                delay(3000)
                navController.navigate("pago_exitoso") {
                    popUpTo("categorias") { inclusive = false }
                }
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                CircularProgressIndicator(color = Color(0xFF00C853))
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    "Procesando pago...",
                    color = Color.White,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}
