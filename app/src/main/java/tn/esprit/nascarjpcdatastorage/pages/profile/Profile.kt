package tn.esprit.nascarjpcdatastorage.pages.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tn.esprit.nascarjpcdatastorage.R
import tn.esprit.nascarjpcdatastorage.utils.AppDatabase

@Preview(showBackground = true)
@Composable
fun Profile() {
    val context = LocalContext.current
    val data = remember{ mutableStateOf(AppDatabase.getInstance(context).eventDao().getAllEvent())}// Initializing as null
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.ic_account_circle),
            contentDescription = "profileImage",
            modifier = Modifier
                .height(150.dp)
                .width(150.dp),
            colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(Color.Black) // Apply gray tint

        )
        Text(
            text = "Name Here",
            modifier = Modifier
                .fillMaxWidth() // equivalent to match_parent
                .padding(10.dp) // margin around the text
            ,
            color = Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center // equivalent to gravity center


        )
        Text(
            text = "Email Here",
            modifier = Modifier
                .fillMaxWidth() // Equivalent to match_parent
                .padding(10.dp), // Margin around the text

            color = Color.Black,
            fontSize = 18.sp,
            textAlign = TextAlign.Center // Equivalent to gravity center
        )
        HorizontalDivider(
            modifier = Modifier.padding(vertical = 5.dp),
            thickness = 1.dp,
            // Add margin if needed
            // Change color as needed
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
            // Change thickness as needed
        )
        Text(
            text = "BookMarks",
            modifier = Modifier
                .fillMaxWidth() // equivalent to match_parent
                .padding(10.dp) // margin around the text
            ,
            color = Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Left
        )


        LazyColumn( modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)) {

            //import androidx.compose.foundation.lazy.items
            items(data.value){
                    item ->
                val onItemRemoved = {
                    data.value = data.value.filter { it.id != item.id }
                }

                BookMarkRow(item,onItemRemoved)
            }
        }

    }
}