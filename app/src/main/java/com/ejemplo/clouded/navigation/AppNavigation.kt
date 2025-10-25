package com.ejemplo.clouded.navigation

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.ejemplo.clouded.ui.screen.*

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AppNavigation() {
    val navController: NavHostController = rememberAnimatedNavController()
    var nombreUsuario by remember { mutableStateOf("") }

    AnimatedNavHost(
        navController = navController,
        startDestination = "login",
        enterTransition = { fadeIn(animationSpec = tween(500)) + scaleIn(initialScale = 0.9f) },
        exitTransition = { fadeOut(animationSpec = tween(400)) + scaleOut(targetScale = 1.1f) },
        popEnterTransition = { fadeIn(animationSpec = tween(500)) + scaleIn(initialScale = 0.95f) },
        popExitTransition = { fadeOut(animationSpec = tween(400)) + scaleOut(targetScale = 1.05f) }
    ) {
        composable("login") {
            LoginScreen(
                onLoginSuccess = { usuario ->
                    nombreUsuario = usuario
                    navController.navigate("categorias")
                },
                onRegisterClick = { navController.navigate("register") }
            )
        }

        composable("register") {
            RegisterScreen(
                onRegisterSuccess = { usuario ->
                    nombreUsuario = usuario
                    navController.navigate("categorias")
                },
                onBackToLogin = { navController.popBackStack() }
            )
        }

        composable("categorias") {
            CategoriaScreen(
                nombreUsuario = nombreUsuario,
                onCategoriaClick = { categoria ->
                    navController.navigate("catalogo/$categoria")
                }
            )
        }

        composable("catalogo/{categoria}") { backStackEntry ->
            val categoria = backStackEntry.arguments?.getString("categoria") ?: "Catálogo"
            CatalogScreen(categoria = categoria, navController = navController)
        }

        composable("detalle/{nombre}/{precio}/{imagen}") { backStackEntry ->
            val nombre = backStackEntry.arguments?.getString("nombre") ?: ""
            val precio = backStackEntry.arguments?.getString("precio")?.toDoubleOrNull() ?: 0.0
            val imagen = backStackEntry.arguments?.getString("imagen")?.toIntOrNull() ?: 0
            ProductoDetalleScreen(nombre, precio, imagen, navController)
        }

        composable("pago_simulado/{nombre}/{total}") { backStackEntry ->
            val nombre = backStackEntry.arguments?.getString("nombre") ?: ""
            val total = backStackEntry.arguments?.getString("total") ?: ""
            PagoSimuladoScreen(nombre, total, navController)
        }

        composable("pago_exitoso") {
            PagoExitosoScreen(navController)
        }

        composable("inicio") {
            InicioScreen()
        }
    }
}



