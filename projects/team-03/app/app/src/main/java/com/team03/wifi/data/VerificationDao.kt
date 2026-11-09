package com.team03.wifi.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface VerificationDao {

    @Insert
    suspend fun insert(verification: Verification)

    // Flow: a lista se atualiza sozinha sempre que a tabela muda.
    @Query("SELECT * FROM verifications ORDER BY createdAt DESC")
    fun getAll(): Flow<List<Verification>>
}