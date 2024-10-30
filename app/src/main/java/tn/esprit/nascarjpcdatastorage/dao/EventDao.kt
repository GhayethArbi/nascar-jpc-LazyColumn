package tn.esprit.nascarjpcdatastorage.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import tn.esprit.nascarjpcdatastorage.models.Event

@Dao
interface EventDao {
    @Insert
    fun insertEvent(events: Event)
    @Update
    fun updateEvent(events: Event)
    @Delete
    fun deleteEvent(events: Event)

    @Query("SELECT * FROM eventTable")
    fun getAllEvent() : List<Event>
    @Query("SELECT * FROM eventTable WHERE id like :id LIMIT 1")
    fun getFindEventById(id: Int) : Event?
}