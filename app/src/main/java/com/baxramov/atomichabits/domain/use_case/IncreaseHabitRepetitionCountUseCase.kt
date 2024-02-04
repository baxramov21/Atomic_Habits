package com.baxramov.atomichabits.domain.use_case

import com.baxramov.atomichabits.domain.repository.HabitTrackerRepository

class IncreaseHabitRepetitionCountUseCase(
    private val repository: HabitTrackerRepository
) {
    suspend operator fun invoke(habitId: Int) = repository.increaseRepetitionCount(habitId)
}