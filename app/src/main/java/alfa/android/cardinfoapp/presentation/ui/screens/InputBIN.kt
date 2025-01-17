package alfa.android.cardinfoapp.presentation.ui.screens

import CardNumberVisual
import alfa.android.cardinfoapp.R
import alfa.android.cardinfoapp.presentation.theme.Typography
import alfa.android.cardinfoapp.presentation.ui.components.ShowCardInfo
import alfa.android.cardinfoapp.presentation.viewmodel.CardInfoViewModel
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun InputBIN(
    navController: NavController,
    viewModel: CardInfoViewModel
) {
    var text by rememberSaveable { mutableStateOf("") }
    var isError by rememberSaveable { mutableStateOf(false) }
    var errorMessage by rememberSaveable { mutableStateOf("") }

    val cardInfo by viewModel.cardInfo.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.card_number),
                style = Typography.titleLarge
            )
            Text(
                text = stringResource(id = R.string.enter_card_number_info),
                style = Typography.labelSmall
            )
            OutlinedTextField(
                modifier = Modifier.padding(top = 40.dp),
                value = text,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                onValueChange = { input ->
                    val digitsOnly = input.replace(" ", "")
                    if (digitsOnly.length <= 8) {
                        text = digitsOnly
                        isError = false
                        errorMessage = ""
                    }
                },
                label = { Text(text = stringResource(id = R.string.input_bin)) },
                isError = isError,
                visualTransformation = CardNumberVisual(),
            )

            if (isError) {
                Text(
                    text = errorMessage,
                    color = Color.Red,
                    style = MaterialTheme.typography.bodySmall
                )
            }
            cardInfo?.onSuccess { info ->
                ShowCardInfo(
                    cardInfo = info
                )
            }?.onFailure {
                Text(
                    text = it.message ?: "Error fetching card info",
                    color = Color.Red,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                modifier = Modifier.size(width = 65.dp, height = 55.dp),
                shape = RoundedCornerShape(5.dp),
                onClick = { navController.navigateUp() },
                colors = ButtonColors(
                    containerColor = Color.Gray,
                    contentColor = Color.Gray,
                    disabledContentColor = Color.Gray,
                    disabledContainerColor = Color.Gray
                )
            ) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                    contentDescription = "back"
                )
            }

            Button(
                modifier = Modifier.size(width = 280.dp, height = 55.dp),
                shape = RoundedCornerShape(5.dp),
                onClick = {
                    if (text.length < 6 || text.length > 8) {
                        isError = true
                        errorMessage = "Enter the first 6 to 8 digits of a card number"
                    } else {
                        isError = false
                        errorMessage = ""
                        viewModel.fetchCardInfo(text)
                    }
                }
            ) {
                Text(
                    text = stringResource(id = R.string.input),
                    style = Typography.bodyLarge
                )
            }
        }
    }
}
