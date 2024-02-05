package com.baxramov.atomichabits.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface HabitsTrackerDao {

    @Query(
        "SELECT * FROM habits_track_table ORDER BY CASE priority " +
                "WHEN 'HIGH' THEN 1" +
                " WHEN 'MEDIUM' THEN 2 " +
                "WHEN 'LOW' THEN 3 " +
                "ELSE 4 END"
    )
    fun getHabitsList(): LiveData<List<HabitDbModel>>

    @Query("SELECT * FROM habits_track_table WHERE id = :habitId")
    fun getHabitItem(habitId: Int): HabitDbModel

    @Upsert
    fun upsertHabitItem(habitDbModel: HabitDbModel)

    @Query("DELETE FROM habits_track_table WHERE id = :habitId")
    fun removeHabitItem(habitId: Int)

    @Query("DELETE FROM habits_track_table")
    fun clearHabitsTrackList()
}