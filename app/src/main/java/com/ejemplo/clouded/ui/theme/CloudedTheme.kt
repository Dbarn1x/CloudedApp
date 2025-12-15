package com.ejemplo.clouded.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

object CloudedColors {
    val FondoNegro = Color(0xFF0D1117)
    val FondoTransparente = Color(0x99000000)
    val VerdePago = Color(0xFF00C853)
    val RojoError = Color(0xFFD50000)
    val AzulPrimario = Color(0xFF1E88E5)
    val BlancoTexto = Color.White
}

private val DarkColorScheme = darkColorScheme(
    primary = CloudedColors.AzulPrimario,
    secondary = CloudedColors.VerdePago,
    background = CloudedColors.FondoNegro,
    onPrimary = CloudedColors.BlancoTexto
)

@Composable
fun CloudedTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColorScheme else lightColorScheme(),
        typography = Typography(),
        content = content
    )
}

@Composable
fun BotonPrimario(texto: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = CloudedColors.VerdePago),
        modifier = Modifier.height(50.dp).width(220.dp)
    ) { Text(texto, color = Color.White, fontWeight = FontWeight.Bold) }
}

@Composable
fun BotonSecundario(texto: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = Color.White),
        modifier = Modifier.height(50.dp).width(220.dp)
    ) { Text(texto, color = Color.Black, fontWeight = FontWeight.Bold) }
}
