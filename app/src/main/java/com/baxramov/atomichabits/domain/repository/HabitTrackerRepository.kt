package com.baxramov.atomichabits.domain.repository

import androidx.lifecycle.LiveData
import com.baxramov.atomichabits.domain.entity.HabitEntity

interface HabitTrackerRepository {

    suspend fun getHabitsList(): LiveData<List<HabitEntity>>

    suspend fun getHabit(habitId: Int): HabitEntity

    suspend fun addNewHabit(habitItem: HabitEntity)

    suspend fun editHabit(habitItem: HabitEntity)

    suspend fun deleteHabit(habitId: Int)

    suspend fun increaseRepetitionCount(habitId: Int)

    suspend fun decreaseRepetitionCount(habitId: Int)

    suspend fun clearHabitsList()
}