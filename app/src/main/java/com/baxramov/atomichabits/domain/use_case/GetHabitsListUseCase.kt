package com.baxramov.atomichabits.domain.use_case

import androidx.lifecycle.LiveData
import com.baxramov.atomichabits.domain.entity.HabitEntity
import com.baxramov.atomichabits.domain.repository.HabitTrackerRepository

class GetHabitsListUseCase(
    private val repository: HabitTrackerRepository
) {
    suspend operator fun invoke(): LiveData<List<HabitEntity>> = repository.getHabitsList()
}