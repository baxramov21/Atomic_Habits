package com.baxramov.atomichabits.presentation.adapter

import com.baxramov.atomichabits.domain.entity.HabitEntity

interface HabitTrackClickListener {
    fun onClick(item: HabitEntity)
}