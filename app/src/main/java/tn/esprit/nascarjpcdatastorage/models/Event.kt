package tn.esprit.nascarjpcdatastorage.models

import androidx.annotation.DrawableRes
import androidx.room.Entity
import androidx.room.PrimaryKey

//data class
@Entity(tableName = "eventTable")
data class Event(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    @DrawableRes
    val image:Int,
    val title:Int,
    val date:Int
)