package com.baxramov.atomichabits.presentation.view_model

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras

class HabitTrackerViewModelFactory(
    private val application: Application
) : ViewModelProvider.AndroidViewModelFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        if (modelClass.isAssignableFrom(HabitTrackerViewModel::class.java))
            return HabitTrackerViewModel(application) as T

        throw IllegalArgumentException("HabitTrackerViewModel instance expected")
    }
}