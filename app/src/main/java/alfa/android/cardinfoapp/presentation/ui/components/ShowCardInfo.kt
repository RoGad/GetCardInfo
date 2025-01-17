package alfa.android.cardinfoapp.presentation.ui.components

import alfa.android.cardinfoapp.domain.model.CardInfo
import alfa.android.cardinfoapp.presentation.theme.Typography
import alfa.android.cardinfoapp.presentation.theme.lightGray
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ShowCardInfo(
    cardInfo: CardInfo
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        colors = CardColors(lightGray, lightGray, lightGray, lightGray)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            cardInfo.scheme?.let {
                InfoRow("Scheme", it)
            }
            cardInfo.type?.let {
                InfoRow("Type", it)
            }
            cardInfo.brand?.let {
                InfoRow("Brand", it)
            }
            cardInfo.bank?.let { bank ->
                bank.name?.let { InfoRow("Bank", it) }
                bank.url?.let { InfoRow("URL", it) }
                bank.phone?.let { InfoRow("Phone", it) }
                bank.city?.let { InfoRow("City", it) }
            }
            cardInfo.country?.let { country ->
                country.name?.let {
                    InfoRow("Country", "${country.emoji ?: ""} $it")
                }
                if (country.latitude != null && country.longitude != null) {
                    InfoRow("Location", "${country.latitude}, ${country.longitude}")
                }
            }
        }
    }
}

@Composable
private fun InfoRow(
    label: String,
    value: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            style = Typography.labelSmall,
        )
        Text(
            text = value,
            style = Typography.bodyLarge
        )
    }
}
