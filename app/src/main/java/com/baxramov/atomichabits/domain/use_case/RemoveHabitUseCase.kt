package com.baxramov.atomichabits.domain.use_case

import com.baxramov.atomichabits.domain.repository.HabitTrackerRepository

class RemoveHabitUseCase(
    private val repository: HabitTrackerRepository
) {
    suspend operator fun invoke(habitId: Int) = repository.removeHabit(habitId)
}