package com.team03.wifi

import androidx.compose.ui.graphics.Color


val BackgroundDark = Color(0xFF0C0E13)
val SurfaceDark = Color(0xFF14171E)
val AccentCyan = Color(0xFF25F2F8)
val TextGray = Color(0xFF7B879F)
val LineGray = Color(0xFF262B36)

enum class SignalStatus(val label: String, val color: Color, val dbm: Int) {
    NONE("Aguardando", TextGray, 0),
    STRONG("Sinal Forte", Color(0xFF35D07F), -45),
    MEDIUM("Sinal Médio", Color(0xFFF5C518), -65),
    WEAK("Sinal Fraco", Color(0xFFF0495A), -85)
}