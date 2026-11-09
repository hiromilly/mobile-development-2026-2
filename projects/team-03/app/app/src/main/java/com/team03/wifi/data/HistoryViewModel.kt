package com.team03.wifi.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

// Fica entre a tela e o banco: a UI não conhece o Room diretamente.
class HistoryViewModel(app: Application) : AndroidViewModel(app) {

    private val dao = AppDatabase.get(app).verificationDao()

    val history: StateFlow<List<Verification>> = dao.getAll()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun save(roomName: String, status: String) {
        viewModelScope.launch {
            dao.insert(Verification(roomName = roomName, status = status))
        }
    }
}