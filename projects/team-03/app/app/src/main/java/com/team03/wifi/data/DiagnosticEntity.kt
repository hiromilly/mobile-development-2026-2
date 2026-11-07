package com.team03.wifi.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "diagnostics")
data class DiagnosticEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val roomName: String,
    val status: String,
    val dbm: Int,
    val timestamp: Long
)
