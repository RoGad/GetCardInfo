package alfa.android.cardinfoapp

import alfa.android.cardinfoapp.data.local.AppDatabase
import alfa.android.cardinfoapp.data.remote.BinListApi
import alfa.android.cardinfoapp.data.repository.CardRepositoryImpl
import alfa.android.cardinfoapp.presentation.theme.CardInfoAppTheme
import alfa.android.cardinfoapp.presentation.ui.screens.InputBIN
import alfa.android.cardinfoapp.presentation.ui.screens.ListHistoryBIN
import alfa.android.cardinfoapp.presentation.ui.screens.MainScreen
import alfa.android.cardinfoapp.presentation.viewmodel.CardInfoViewModel
import alfa.android.cardinfoapp.presentation.viewmodel.CardInfoViewModelFactory
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    private lateinit var viewModel: CardInfoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val database = AppDatabase.getInstance(this)
        val retrofit = Retrofit.Builder()
            .baseUrl(BinListApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api = retrofit.create(BinListApi::class.java)
        val repository = CardRepositoryImpl(api, database.cardInfoDao())
        val viewModelFactory = CardInfoViewModelFactory(repository)

        viewModel = ViewModelProvider(this, viewModelFactory)[CardInfoViewModel::class.java]

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
                    composable("main_screen") {
                        MainScreen(navController)
                    }
                    composable("input_bin") {
                        InputBIN(navController, viewModel)
                    }
                    composable("list_history_bin") {
                        ListHistoryBIN(viewModel, navController)
                    }
                }
            }
        }
    }
}
