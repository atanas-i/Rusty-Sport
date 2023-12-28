package dev.rustybite.rustysport.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.rustybite.rustysport.presentation.navigations.RustySportsNavHost
import dev.rustybite.rustysport.ui.theme.RustySportTheme

@AndroidEntryPoint
class RustySportsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            RustySportTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme
                        .colorScheme
                        .background
                ) {
                    RustySportsNavHost(navController = navController)
                }
            }
        }
    }
}