package com.team03.wifi.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Verification::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun verificationDao(): VerificationDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        // Garante que existe só um banco em todo o app.
        fun get(context: Context): AppDatabase =
            instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "wiflux.db"
                ).build().also { instance = it }
            }
    }
}