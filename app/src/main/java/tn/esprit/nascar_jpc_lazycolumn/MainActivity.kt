package tn.esprit.nascar_jpc_lazycolumn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import tn.esprit.nascar_jpc_lazycolumn.ui.theme.NascarjpcLazyColumnTheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NascarjpcLazyColumnTheme {
                PreviewHome()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewHome() {
    val navController = rememberNavController() // Create a NavController


    Column {
        MyToolbar(navController)
        NavigationScreen(navController)
    }

}