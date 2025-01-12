package alfa.android.cardinfoapp.presentation.ui.screens

import alfa.android.cardinfoapp.R
import alfa.android.cardinfoapp.presentation.theme.Typography
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MainScreen(){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            Button(
               // modifier = Modifier.size(width = 280.dp, height = 55.dp),
                shape = RoundedCornerShape(5.dp),
                onClick = { /*TODO*/ }
            ) {
                Text(
                    text = stringResource(id = R.string.input),
                    style = Typography.bodyLarge
                )
            }
            Button(
               // modifier = Modifier.size(width = 280.dp, height = 55.dp),
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
}

@Preview(showBackground = true, name = "Default Preview")
@Composable fun MainScreenPreview() {
    MainScreen()
}