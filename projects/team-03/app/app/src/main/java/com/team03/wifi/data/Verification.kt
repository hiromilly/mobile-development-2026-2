package com.team03.wifi.data

import androidx.room.Entity
import androidx.room.PrimaryKey

// Uma linha da tabela = uma verificação feita pelo usuário.
@Entity(tableName = "verifications")
data class Verification(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val roomName: String,                            // nome do cômodo (Sprint 04)
    val status: String,                              // SignalStatus.name: STRONG, MEDIUM ou WEAK (Sprint 02)
    val createdAt: Long = System.currentTimeMillis() // data/hora em milissegundos
)