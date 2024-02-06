package com.baxramov.atomichabits.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.baxramov.atomichabits.databinding.HabitItemBinding
import com.baxramov.atomichabits.domain.entity.HabitEntity

class HabitTrackAdapter : ListAdapter<HabitEntity, HabitTrackerViewHolder>(
    HabitTrackerDiffUtil
) {

    var onHabitTrackClickListener: HabitTrackClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HabitTrackerViewHolder {
        val binding = HabitItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return HabitTrackerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HabitTrackerViewHolder, position: Int) {
        val habitTrack: HabitEntity = getItem(position)
        val binding = holder.habitTrackerBinding

        with(habitTrack) {
            with(binding) {
                textViewHabitName.text = name
                textViewHabitRepCount.text = repetitionCount.toString()

                val progress = (repetitionCount / repetitionGoal) * 100
                progressBarHabitProgress.progress = progress
            }
        }
        holder.itemView.setOnClickListener {
            onHabitTrackClickListener?.onClick(habitTrack)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return ITEM_VIEW_TYPE
    }

    companion object {
        const val ITEM_VIEW_TYPE = 1
        const val RECYCLER_VIEW_POOL = 20
    }
}