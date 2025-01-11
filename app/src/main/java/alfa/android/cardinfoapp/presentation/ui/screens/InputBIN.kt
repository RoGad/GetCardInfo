package alfa.android.cardinfoapp.presentation.ui.screens

import alfa.android.cardinfoapp.R
import alfa.android.cardinfoapp.presentation.theme.Typography
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun InputBIN() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            contentAlignment = Alignment.Center,
        ){
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
                var text by remember { mutableStateOf("44455656") }

                OutlinedTextField(
                    modifier = Modifier.padding(top = 40.dp),
                    value = text,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    onValueChange = {text = it},
                    label = { Text(text = stringResource(id = R.string.input_bin)) }
                )
            }
        }
        Button(
            modifier = Modifier.size(width = 280.dp, height = 55.dp),
            shape = RoundedCornerShape(5.dp),
            onClick = { /*TODO*/ }
        ) {
            Text(
                text = stringResource(id = R.string.input),
                style = Typography.bodyLarge
            )
        }
    }
}

