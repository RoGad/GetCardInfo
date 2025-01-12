package alfa.android.cardinfoapp

import alfa.android.cardinfoapp.presentation.theme.CardInfoAppTheme
import alfa.android.cardinfoapp.presentation.ui.screens.InputBIN
import alfa.android.cardinfoapp.presentation.ui.screens.ListHistoryBIN
import alfa.android.cardinfoapp.presentation.ui.screens.MainScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CardInfoAppTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "main_screen",
                    enterTransition = { fadeIn(initialAlpha = 1f) },
                    exitTransition = { fadeOut(targetAlpha = 1f) },
                    popEnterTransition = { fadeIn(initialAlpha = 1f) },
                    popExitTransition = { fadeOut(targetAlpha = 1f) }
                ) {
                    composable("main_screen") { MainScreen(navController) }
                    composable("input_bin") { InputBIN(navController) }
                    composable("list_history_bin") { ListHistoryBIN() }
                }
            }
        }
    }
}
