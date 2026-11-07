package com.team03.wifi.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface DiagnosticDao {

    @Insert
    suspend fun insert(diagnostic: DiagnosticEntity)

    @Query("SELECT * FROM diagnostics ORDER BY timestamp DESC LIMIT 1")
    fun getLastDiagnostic(): Flow<DiagnosticEntity?>
}
