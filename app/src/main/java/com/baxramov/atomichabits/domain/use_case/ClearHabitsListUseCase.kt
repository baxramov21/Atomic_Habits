package com.baxramov.atomichabits.domain.use_case

import com.baxramov.atomichabits.domain.repository.HabitTrackerRepository

class ClearHabitsListUseCase(
    private val repository: HabitTrackerRepository
) {
    suspend operator fun invoke() = repository.clearHabitsList()
}