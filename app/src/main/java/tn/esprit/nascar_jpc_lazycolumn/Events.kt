package tn.esprit.nascar_jpc_lazycolumn

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
//import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.foundation.verticalScroll
//import androidx.compose.ui.Alignment



//data class
data class EventsDetails(
    val image:Int,
    val title:Int,
    val date:Int
)


@Preview(showBackground = true)
@Composable
fun Events(){
    //exents list
   // val data = remember {
    //    List(100) { EventsDetails(R.drawable.ic_event1, R.string.event1, R.string.eventDate1) }
    //}
    val data = listOf(
        EventsDetails(R.drawable.ic_event1, R.string.event1, R.string.eventDate1),
        EventsDetails(R.drawable.ic_event2, R.string.event2, R.string.eventDate2),
        EventsDetails(R.drawable.ic_event3, R.string.event3, R.string.eventDate3),
        EventsDetails(R.drawable.ic_event4, R.string.event4, R.string.eventDate4),
        EventsDetails(R.drawable.ic_event1, R.string.event1, R.string.eventDate1),
        EventsDetails(R.drawable.ic_event2, R.string.event2, R.string.eventDate2),
        EventsDetails(R.drawable.ic_event3, R.string.event3, R.string.eventDate3),
        EventsDetails(R.drawable.ic_event4, R.string.event4, R.string.eventDate4)
    )
    //lazyColumn
    LazyColumn( modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)) {

        //import androidx.compose.foundation.lazy.items
        items(data){
                item ->
            EventsRow(item)
        }
    }


}
/*Column(
       horizontalAlignment = Alignment.CenterHorizontally,
       modifier = Modifier
           .fillMaxSize()
           .verticalScroll(rememberScrollState())
   ) {
       EventsRow(R.drawable.ic_event1,R.string.event1,R.string.eventDate1)
       EventsRow(R.drawable.ic_event2,R.string.event2,R.string.eventDate2)
       EventsRow(R.drawable.ic_event1,R.string.event1,R.string.eventDate1)
       EventsRow(R.drawable.ic_event4,R.string.event4,R.string.eventDate4)
       EventsRow(R.drawable.ic_event1,R.string.event1,R.string.eventDate1)
       EventsRow(R.drawable.ic_event2,R.string.event2,R.string.eventDate2)
       EventsRow(R.drawable.ic_event1,R.string.event1,R.string.eventDate1)
       EventsRow(R.drawable.ic_event4,R.string.event4,R.string.eventDate4)

   }*/
