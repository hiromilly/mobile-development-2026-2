package com.team03.wifi

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.team03.wifi.data.Verification
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

// Mostra as 5 últimas verificações salvas no banco (Sprint 05).
@Composable
fun HistoryList(items: List<Verification>) {
    val formato = remember { SimpleDateFormat("dd/MM HH:mm", Locale.getDefault()) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(SurfaceDark, RoundedCornerShape(20.dp))
            .padding(16.dp)
    ) {
        Text(
            text = "Últimas verificações",
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))

        if (items.isEmpty()) {
            Text("Nenhuma verificação salva ainda", color = TextGray, fontSize = 14.sp)
        } else {
            items.take(5).forEach { item ->
                // O banco guarda o nome do enum; aqui voltamos para o SignalStatus
                val status = SignalStatus.entries.firstOrNull { it.name == item.status }
                    ?: SignalStatus.NONE

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = item.roomName,
                            color = Color.White,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Text(
                            text = formato.format(Date(item.createdAt)),
                            color = TextGray,
                            fontSize = 12.sp
                        )
                    }
                    Text(
                        text = status.label,
                        color = status.color,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    }
}