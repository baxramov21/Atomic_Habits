package com.baxramov.atomichabits.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.baxramov.atomichabits.domain.entity.HabitEntity

object HabitTrackerDiffUtil : DiffUtil.ItemCallback<HabitEntity>() {
    override fun areItemsTheSame(oldItem: HabitEntity, newItem: HabitEntity): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: HabitEntity, newItem: HabitEntity): Boolean {
        return oldItem == newItem
    }
}