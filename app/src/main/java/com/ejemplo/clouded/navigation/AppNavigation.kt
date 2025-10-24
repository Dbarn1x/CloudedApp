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
        enterTransition = {
            fadeIn(animationSpec = tween(500)) + scaleIn(initialScale = 0.9f)
        },
        exitTransition = {
            fadeOut(animationSpec = tween(400)) + scaleOut(targetScale = 1.1f)
        },
        popEnterTransition = {
            fadeIn(animationSpec = tween(500)) + scaleIn(initialScale = 0.95f)
        },
        popExitTransition = {
            fadeOut(animationSpec = tween(400)) + scaleOut(targetScale = 1.05f)
        }
    ) {
        // 🔹 Pantalla de inicio de sesión
        composable("login") {
            LoginScreen(
                onLoginSuccess = { usuario ->
                    nombreUsuario = usuario
                    navController.navigate("categorias")
                },
                onRegisterClick = { navController.navigate("register") }
            )
        }

        // 🔹 Pantalla de registro
        composable("register") {
            RegisterScreen(
                onRegisterSuccess = { usuario ->
                    nombreUsuario = usuario
                    navController.navigate("categorias")
                },
                onBackToLogin = { navController.popBackStack() }
            )
        }

        // 🔹 Pantalla de categorías
        composable("categorias") {
            CategoriaScreen(nombreUsuario) { categoriaSeleccionada ->
                navController.navigate("catalog")
            }
        }

        // 🔹 Pantalla del catálogo
        composable("catalog") {
            CatalogScreen { producto -> }
        }

        // 🔹 Pantalla opcional
        composable("inicio") {
            InicioScreen()
        }
    }
}


