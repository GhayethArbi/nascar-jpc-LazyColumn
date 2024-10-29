package tn.esprit.nascarjpcdatastorage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import tn.esprit.nascarjpcdatastorage.ui.theme.NascarJPCDataStorageTheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NascarJPCDataStorageTheme {
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