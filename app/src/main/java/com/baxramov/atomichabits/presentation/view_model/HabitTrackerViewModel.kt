package com.baxramov.atomichabits.presentation.view_model

import android.app.Application
import androidx.lifecycle.ViewModel
import com.baxramov.atomichabits.data.repository.HabitTrackerRepositoryImpl
import com.baxramov.atomichabits.domain.use_case.AddNewHabitUseCase
import com.baxramov.atomichabits.domain.use_case.ClearHabitsListUseCase
import com.baxramov.atomichabits.domain.use_case.DecreaseRepetitionCountUseCase
import com.baxramov.atomichabits.domain.use_case.DeleteHabitUseCase
import com.baxramov.atomichabits.domain.use_case.EditHabitUseCase
import com.baxramov.atomichabits.domain.use_case.GetHabitUseCase
import com.baxramov.atomichabits.domain.use_case.GetHabitsListUseCase
import com.baxramov.atomichabits.domain.use_case.IncreaseHabitRepetitionCountUseCase

class HabitTrackerViewModel(
    private val application: Application
) : ViewModel() {

    private val repository = HabitTrackerRepositoryImpl(application)

    private val getHabitsList = GetHabitsListUseCase(repository)
    private val getHabit = GetHabitUseCase(repository)
    private val addNewHabit = AddNewHabitUseCase(repository)
    private val deleteHabit = DeleteHabitUseCase(repository)
    private val clearHabitsList = ClearHabitsListUseCase(repository)
    private val editHabit = EditHabitUseCase(repository)
    private val increaseHabitRepetitionCount = IncreaseHabitRepetitionCountUseCase(repository)
    private val decreaseRepetitionCount = DecreaseRepetitionCountUseCase(repository)
}