package com.baxramov.atomichabits.domain.repository

import androidx.lifecycle.LiveData
import com.baxramov.atomichabits.domain.entity.HabitEntity

interface HabitTrackerRepository {

    suspend fun getHabitsList(): LiveData<List<HabitEntity>>

    suspend fun getHabitItem(habitId: Int): HabitEntity

    suspend fun addNewHabit(habitItem: HabitEntity)

    suspend fun editHabit(habitItem: HabitEntity)

    suspend fun removeHabit(habitId: Int)

    suspend fun increaseRepetitionCount(habitId: Int)

    suspend fun decreaseRepetitionCount(habitId: Int)

    suspend fun clearHabitsList()
}