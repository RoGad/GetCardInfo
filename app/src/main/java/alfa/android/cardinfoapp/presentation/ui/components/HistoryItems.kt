package alfa.android.cardinfoapp.presentation.ui.components

import alfa.android.cardinfoapp.domain.model.CardInfo
import alfa.android.cardinfoapp.presentation.theme.Typography
import alfa.android.cardinfoapp.presentation.theme.White
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HistoryItem(
    bin: String,
    cardInfo: CardInfo,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                text = "BIN: $bin",
                style = Typography.titleMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            cardInfo.scheme?.let {
                Text(
                    text = "Scheme: $it",
                    color = White
                )
            }
            cardInfo.brand?.let {
                Text(
                    text = "Brand: $it",
                    color = White
                )
            }
            cardInfo.country?.name?.let {
                Text(
                    text = "Country: ${cardInfo.country.emoji ?: ""} $it",
                    color = White
                )
            }
        }
    }
}
