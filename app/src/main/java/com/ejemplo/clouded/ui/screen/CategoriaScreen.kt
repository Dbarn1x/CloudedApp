package com.ejemplo.clouded.ui.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
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
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Bienvenido $nombreUsuario",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Indícanos lo que buscas",
                color = Color.White,
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.height(25.dp))
            val categorias = listOf(
                "Calzado",
                "Música",
                "Ropa",
                "Accesorios",
                "Tecnología",
                "Hogar"
            )
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(20.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                items(categorias.size) { index ->
                    val categoria = categorias[index]
                    val isLeft = index % 2 == 0
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp),
                        horizontalArrangement = if (isLeft) Arrangement.Start else Arrangement.End
                    ) {
                        AnimatedVisibility(
                            visible = true,
                            enter = fadeIn() + slideInHorizontally(
                                initialOffsetX = { if (isLeft) -200 else 200 }
                            )
                        ) {
                            Card(
                                modifier = Modifier
                                    .width(160.dp)
                                    .height(55.dp)
                                    .clickable { onCategoriaClick(categoria) }
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxSize(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = categoria,
                                        fontWeight = FontWeight.Bold,
                                        fontStyle = FontStyle.Italic,
                                        color = Color.Black,
                                        textAlign = TextAlign.Center
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}


