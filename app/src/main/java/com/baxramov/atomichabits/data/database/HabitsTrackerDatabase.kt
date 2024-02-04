package com.baxramov.atomichabits.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [HabitDbModel::class],
    version = 1,
    exportSchema = false
)
abstract class HabitsTrackerDatabase : RoomDatabase() {

    abstract fun habitsTrackerDao(): HabitsTrackerDao

    companion object {

        private val LOCK = Any()
        private var database: HabitsTrackerDatabase? = null
        private const val DB_NAME = "habits_track_database"

        fun getInstance(context: Context): HabitsTrackerDatabase {
            synchronized(LOCK) {
                database?.let { return it }

                val instance = Room
                    .databaseBuilder(context, HabitsTrackerDatabase::class.java, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .build()

                database = instance
                return instance
            }
        }
    }
}