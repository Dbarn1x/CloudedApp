package com.ejemplo.clouded

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.ejemplo.clouded.navigation.AppNavigation
import com.ejemplo.clouded.ui.theme.CloudedTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CloudedTheme {
                AppNavigation()
            }
        }
    }
}
