package tn.esprit.nascarjpcdatastorage.pages.profile

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import tn.esprit.nascarjpcdatastorage.models.Event
import tn.esprit.nascarjpcdatastorage.R
import tn.esprit.nascarjpcdatastorage.utils.AppDatabase

@Composable
fun BookMarkRow(event: Event,onItemRemoved: () -> Unit) {
    val context = LocalContext.current
    val eventDao = AppDatabase.getInstance(context).eventDao()
    val foundEvent = eventDao.getFindEventById(event.id)


    Card(
        colors = CardColors(
            contentColor = Color.White,
            containerColor = Color.White,
            disabledContentColor = Color.White,
            disabledContainerColor = Color.White
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Row(modifier = Modifier.padding(5.dp)) {
            Image(
                painter = painterResource(event.image),
                contentDescription = "Event Image",
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp)
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = stringResource(event.title),
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.Black
                )
                Text(
                    text = stringResource(event.date),
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(0xFFFF0000)
                )
                BookmarkImageDelete(
                    onClick = {
                        deleteEventBookmark(event, foundEvent, context)
                        onItemRemoved()
                    }
                )
            }
        }
    }
}

@Composable
fun BookmarkImageDelete(onClick: () -> Unit) {
    Image(
        painter = painterResource(R.drawable.ic_bookmark_remove),
        contentDescription = "Add Bookmark",
        modifier = Modifier.clickable(onClick = onClick)
    )
}

fun deleteEventBookmark(event: Event, foundEvent: Event?, context: android.content.Context) {
    if (foundEvent != null) {
        AppDatabase.getInstance(context).eventDao().deleteEvent(event)
        Toast.makeText(context , "Event removed successfully.", Toast.LENGTH_SHORT).show()
    }
}
