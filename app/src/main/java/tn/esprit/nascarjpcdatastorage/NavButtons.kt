package tn.esprit.nascarjpcdatastorage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun NavButtons(navController: NavHostController) {
    Row(    modifier = Modifier
        .fillMaxWidth().background(color = Color.White),

    ) {
        Button(
            onClick = { navController.navigate("news") },
            modifier = Modifier.weight(1f),
            colors = ButtonDefaults.buttonColors(
                // Button background color
                containerColor = Color.White,
                // Text and icon color
                contentColor = Color.Black
            )
        ) {
            Text(
                "News",
                fontSize = 20.sp
            )
        }
        Button(
            onClick = {navController.navigate("events")},
            modifier = Modifier.weight(1f),
            colors = ButtonDefaults.buttonColors(
                // Button background color
                containerColor = Color.White,
                // Text and icon color
                contentColor = Color.Black
            )
        ) {
            Text(
                "Events",
                fontSize = 20.sp
            )
        }
        Button(
            onClick = {navController.navigate("profile")},
            modifier = Modifier.weight(1f),
            colors = ButtonDefaults.buttonColors(
                // Button background color
                containerColor = Color.White,
                // Text and icon color
                contentColor = Color.Black
            )
        ) {
            Text(
                "Profile",
                fontSize = 20.sp
            )
        }
    }
}