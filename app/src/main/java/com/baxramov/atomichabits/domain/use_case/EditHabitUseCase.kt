package com.baxramov.atomichabits.domain.use_case

import com.baxramov.atomichabits.domain.entity.HabitEntity
import com.baxramov.atomichabits.domain.repository.HabitTrackerRepository

class EditHabitUseCase(
    private val repository: HabitTrackerRepository
) {
    suspend operator fun invoke(habitItem: HabitEntity) = repository.editHabit(habitItem)
}