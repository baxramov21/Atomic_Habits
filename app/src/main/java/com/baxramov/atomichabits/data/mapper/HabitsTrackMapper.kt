package com.baxramov.atomichabits.data.mapper

import com.baxramov.atomichabits.data.database.HabitDbModel
import com.baxramov.atomichabits.domain.entity.HabitEntity

class HabitsTrackMapper {

    fun dbModelToEntity(habitDbModel: HabitDbModel): HabitEntity {
        return HabitEntity(
            id = habitDbModel.id,
            name = habitDbModel.name,
            repetitionCount = habitDbModel.repetitionCount,
            repetitionGoal = habitDbModel.repetitionGoal,
            priority = habitDbModel.priority
        )
    }

    fun dbModelListToEntityList(habitDbModelList: List<HabitDbModel>): List<HabitEntity> {
        return habitDbModelList.map { dbModelToEntity(it) }
    }

    fun entityToDbModel(habitEntity: HabitEntity): HabitDbModel {
        return HabitDbModel(
            id = habitEntity.id,
            name = habitEntity.name,
            repetitionCount = habitEntity.repetitionCount,
            repetitionGoal = habitEntity.repetitionGoal,
            priority = habitEntity.priority
        )
    }

    fun entityListToDbModelList(habitEntityList: List<HabitEntity>): List<HabitDbModel> {
        return habitEntityList.map { entityToDbModel(it) }
    }
}