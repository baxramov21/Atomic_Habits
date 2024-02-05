package com.baxramov.atomichabits.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.baxramov.atomichabits.data.database.HabitDbModel
import com.baxramov.atomichabits.data.database.HabitsTrackerDatabase
import com.baxramov.atomichabits.data.mapper.HabitsTrackMapper
import com.baxramov.atomichabits.domain.entity.HabitEntity
import com.baxramov.atomichabits.domain.repository.HabitTrackerRepository

class HabitTrackerRepositoryImpl(
    private val application: Application
) : HabitTrackerRepository {

    private val db = HabitsTrackerDatabase.getInstance(application).habitsTrackerDao()
    private val mapper = HabitsTrackMapper()

    override suspend fun getHabitsList(): LiveData<List<HabitEntity>> {
        return MediatorLiveData<List<HabitEntity>>().apply {
            addSource(db.getHabitsList()) {
                value = mapper.dbModelListToEntityList(it)
            }
        }
    }

    override suspend fun getHabitItem(habitId: Int): HabitEntity {
        return mapper.dbModelToEntity(db.getHabitItem(habitId))
    }

    override suspend fun addNewHabit(habitItem: HabitEntity) {
        db.upsertHabitItem(
            mapper.entityToDbModel(habitItem)
        )
    }

    override suspend fun editHabit(habitItem: HabitEntity) {
        db.upsertHabitItem(
            mapper.entityToDbModel(habitItem)
        )
    }

    override suspend fun removeHabit(habitId: Int) {
        db.removeHabitItem(habitId)
    }

    override suspend fun increaseRepetitionCount(habitId: Int) {
        val habitWithPreviousRepCount = db.getHabitItem(habitId)
        val updatedHabit = habitWithPreviousRepCount.copy(
            repetitionCount = increasedRepCount(habitWithPreviousRepCount)
        )
        db.upsertHabitItem(updatedHabit)
    }

    override suspend fun decreaseRepetitionCount(habitId: Int) {
        val habitWithPreviousRepCount = db.getHabitItem(habitId)
        val updatedHabit = habitWithPreviousRepCount.copy(
            repetitionCount = decreasedRepCount(habitWithPreviousRepCount)
        )
        db.upsertHabitItem(updatedHabit)
    }

    override suspend fun clearHabitsList() {
        db.clearHabitsTrackList()
    }

    private fun increasedRepCount(habitItem: HabitDbModel): Int {
        return habitItem.repetitionCount + 1
    }

    private fun decreasedRepCount(habitItem: HabitDbModel): Int {
        return habitItem.repetitionCount - 1
    }
}