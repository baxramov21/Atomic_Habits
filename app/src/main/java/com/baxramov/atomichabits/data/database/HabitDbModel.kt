package com.baxramov.atomichabits.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.baxramov.atomichabits.domain.entity.HabitPriority

@Entity(tableName = "habits_track_table")
data class HabitDbModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val repetitionCount: Int,
    val repetitionGoal: Int,
    val priority: HabitPriority
)