package com.baxramov.atomichabits.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.baxramov.atomichabits.data.mapper.HabitsTrackMapper
import com.baxramov.atomichabits.data.database.HabitsTrackerDatabase
import com.baxramov.atomichabits.domain.entity.HabitEntity
import com.baxramov.atomichabits.domain.repository.HabitTrackerRepository

class HabitTrackerRepositoryImpl(
    private val application: Application
) : HabitTrackerRepository {

    private val db = HabitsTrackerDatabase.getInstance(application)
    private val mapper = HabitsTrackMapper()

    override suspend fun getHabitsList(): LiveData<List<HabitEntity>> {
        TODO("Not yet implemented")
    }

    override suspend fun getHabitItem(habitId: Int): HabitEntity {
        TODO("Not yet implemented")
    }

    override suspend fun addNewHabit(habitItem: HabitEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun editHabit(habitItem: HabitEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun removeHabit(habitId: Int) {
        TODO("Not yet implemented")
    }

    override suspend fun increaseRepetitionCount(habitId: Int) {
        TODO("Not yet implemented")
    }

    override suspend fun decreaseRepetitionCount(habitId: Int) {
        TODO("Not yet implemented")
    }

    override suspend fun clearHabitsList() {
        TODO("Not yet implemented")
    }

}