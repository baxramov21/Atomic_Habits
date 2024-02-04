package com.baxramov.atomichabits.domain.entity

data class HabitEntity(
    val id: Int,
    val name: String,
    val repetitionTime: Int,
    val repetitionGoal: Int,
    val priority: HabitPriority
)