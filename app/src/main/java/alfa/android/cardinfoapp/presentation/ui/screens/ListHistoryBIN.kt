package alfa.android.cardinfoapp.presentation.ui.screens

import alfa.android.cardinfoapp.presentation.theme.Typography
import alfa.android.cardinfoapp.presentation.ui.components.HistoryItem
import alfa.android.cardinfoapp.presentation.viewmodel.CardInfoViewModel
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ListHistoryBIN(
    viewModel: CardInfoViewModel,
    navController: NavController
) {
    val history by viewModel.history.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadHistory()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Search History",
            style = Typography.titleLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyColumn {
            items(history) { (bin, cardInfo) ->
                HistoryItem(bin, cardInfo) {
                    navController.navigate("show_card_info/$bin")
                }
                HorizontalDivider()
            }
        }
    }
}
