package alfa.android.cardinfoapp.presentation.ui.screens

import alfa.android.cardinfoapp.R
import alfa.android.cardinfoapp.presentation.theme.Typography
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun MainScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.tittle_app),
                style = Typography.titleLarge
            )
            Text(
                text = stringResource(id = R.string.info_app),
                style = Typography.labelSmall
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    modifier = Modifier.size(width = 150.dp, height = 150.dp),
                    shape = RoundedCornerShape(10.dp),
                    onClick = { navController.navigate("input_bin") }
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.free_icon_keyboard_1021285),
                        contentDescription = "icon history"
                    )
                }
                Text(
                    modifier = Modifier.padding(top = 10.dp),
                    text = stringResource(id = R.string.manual_input_bin_screen),
                    style = Typography.bodyLarge
                )
            }
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    modifier = Modifier.size(width = 150.dp, height = 150.dp),
                    shape = RoundedCornerShape(10.dp),
                    onClick = { /*TODO*/ }
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.free_icon_history_1985745),
                        contentDescription = "icon history"
                    )
                }
                Text(
                    modifier = Modifier.padding(top = 10.dp),
                    text = stringResource(id = R.string.show_history_screen),
                    style = Typography.bodyLarge
                )
            }
        }
    }
}

//@Preview(showBackground = true, name = "Default Preview")
//@Composable
//fun MainScreenPreview() {
//    MainScreen(navController = )
//}