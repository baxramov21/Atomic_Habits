package com.baxramov.atomichabits.domain.use_case

import com.baxramov.atomichabits.domain.entity.HabitEntity
import com.baxramov.atomichabits.domain.repository.HabitTrackerRepository

class GetHabitUseCase(
    private val repository: HabitTrackerRepository
) {
    suspend operator fun invoke(habitId: Int): HabitEntity = repository.getHabit(habitId)
}