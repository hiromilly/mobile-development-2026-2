package com.team03.wifi

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.team03.wifi.data.Verification
import kotlin.math.cos
import kotlin.math.sin
import kotlin.random.Random

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onSeeDetails: (SignalStatus) -> Unit,
    history: List<Verification> = emptyList(),
    onSave: (String, SignalStatus) -> Unit = { _, _ -> }
) {
    var signalStatus by rememberSaveable { mutableStateOf(SignalStatus.NONE) }
    var roomName by rememberSaveable { mutableStateOf("") }
    var roomError by rememberSaveable { mutableStateOf(false) }

    // Brilho de fundo na cor do status atual
    val glowAlpha = if (signalStatus == SignalStatus.NONE) 0f else 0.16f

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(BackgroundDark)
            .background(
                Brush.verticalGradient(
                    colors = listOf(signalStatus.color.copy(alpha = glowAlpha), Color.Transparent),
                    endY = 1400f
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp, vertical = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Cabeçalho
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(44.dp)
                        .border(2.dp, AccentCyan, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    WifiIcon(color = AccentCyan, modifier = Modifier.size(22.dp))
                }
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text("Wiflux", color = Color.White, fontSize = 17.sp, fontWeight = FontWeight.Bold)
                    Text("SIGNAL DIAGNOSTICS", color = TextGray, fontSize = 10.sp, letterSpacing = 1.5.sp)
                }
            }

            Spacer(modifier = Modifier.height(28.dp))

            Text(
                text = "Verificação de Sinal",
                color = Color.White,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = "Mapeie a rede. Conecte no melhor ponto.",
                color = AccentCyan,
                fontSize = 14.sp,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(20.dp))

            SignalGauge(status = signalStatus)

            Spacer(modifier = Modifier.height(12.dp))

            // Chip de status
            Box(
                modifier = Modifier
                    .background(signalStatus.color.copy(alpha = 0.08f), RoundedCornerShape(50))
                    .border(1.dp, signalStatus.color.copy(alpha = 0.4f), RoundedCornerShape(50))
                    .padding(horizontal = 22.dp, vertical = 9.dp)
            ) {
                Text(
                    text = signalStatus.label,
                    color = signalStatus.color,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Campo validado (Sprint 04)
            OutlinedTextField(
                value = roomName,
                onValueChange = {
                    roomName = it
                    roomError = false
                },
                label = { Text("Nome do cômodo") },
                isError = roomError,
                supportingText = {
                    if (roomError) Text("Digite pelo menos 3 letras")
                },
                singleLine = true,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    focusedLabelColor = AccentCyan,
                    unfocusedLabelColor = TextGray,
                    focusedBorderColor = AccentCyan,
                    unfocusedBorderColor = LineGray
                ),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = {
                    if (roomName.trim().length < 3) {
                        roomError = true
                    } else {
                        roomError = false
                        val novoStatus = SignalStatus.entries
                            .filter { it != SignalStatus.NONE }
                            .random(Random(System.nanoTime()))
                        signalStatus = novoStatus
                        onSave(roomName.trim(), novoStatus) // Sprint 05: salva no banco
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = AccentCyan, contentColor = Color.Black),
                shape = RoundedCornerShape(18.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(58.dp)
                    .shadow(24.dp, RoundedCornerShape(18.dp), ambientColor = AccentCyan, spotColor = AccentCyan)
            ) {
                Text("▶  Iniciar Verificação", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }

            // Navegação (Sprint 03)
            if (signalStatus != SignalStatus.NONE) {
                Spacer(modifier = Modifier.height(12.dp))
                Button(
                    onClick = { onSeeDetails(signalStatus) },
                    colors = ButtonDefaults.buttonColors(containerColor = SurfaceDark, contentColor = AccentCyan),
                    shape = RoundedCornerShape(18.dp),
                    modifier = Modifier.fillMaxWidth().height(48.dp)
                ) {
                    Text("Ver Detalhes", fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
                }
            }

            // Histórico salvo no banco (Sprint 05)
            Spacer(modifier = Modifier.height(24.dp))
            HistoryList(items = history)

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

// Medidor circular: marcas ao redor + arco proporcional à intensidade
@Composable
private fun SignalGauge(status: SignalStatus) {
    Box(modifier = Modifier.size(280.dp), contentAlignment = Alignment.Center) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val center = Offset(size.width / 2f, size.height / 2f)
            val outer = size.minDimension / 2f

            // Marcas (72 traços, um a cada 5°)
            for (i in 0 until 72) {
                val angle = Math.toRadians((i * 5 - 90).toDouble())
                val dx = cos(angle).toFloat()
                val dy = sin(angle).toFloat()
                val length = if (i % 6 == 0) 14.dp.toPx() else 8.dp.toPx()
                drawLine(
                    color = TextGray.copy(alpha = 0.35f),
                    start = Offset(center.x + dx * (outer - length), center.y + dy * (outer - length)),
                    end = Offset(center.x + dx * outer, center.y + dy * outer),
                    strokeWidth = 1.5.dp.toPx()
                )
            }

            // Arco: -100 dBm = vazio, -40 dBm = volta completa
            if (status != SignalStatus.NONE) {
                val fraction = ((status.dbm + 100) / 60f).coerceIn(0f, 1f)
                val arcRadius = outer - 28.dp.toPx()
                drawArc(
                    color = status.color,
                    startAngle = -90f,
                    sweepAngle = 360f * fraction,
                    useCenter = false,
                    topLeft = Offset(center.x - arcRadius, center.y - arcRadius),
                    size = Size(arcRadius * 2, arcRadius * 2),
                    style = Stroke(width = 3.dp.toPx(), cap = StrokeCap.Round)
                )
            }
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Box(
                modifier = Modifier
                    .size(56.dp)
                    .background(status.color.copy(alpha = 0.12f), CircleShape)
                    .border(1.dp, status.color.copy(alpha = 0.4f), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                WifiIcon(color = status.color, modifier = Modifier.size(26.dp))
            }
            Spacer(modifier = Modifier.height(12.dp))
            Row(verticalAlignment = Alignment.Bottom) {
                Text(
                    text = if (status == SignalStatus.NONE) "—" else "${status.dbm}",
                    color = status.color,
                    fontSize = 52.sp,
                    fontWeight = FontWeight.Bold
                )
                if (status != SignalStatus.NONE) {
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "dBm",
                        color = TextGray,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(bottom = 10.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun WifiIcon(color: Color, modifier: Modifier = Modifier) {
    Canvas(modifier = modifier) {
        val stroke = size.minDimension * 0.09f
        val cx = size.width / 2f
        val cy = size.height * 0.82f
        for (i in 1..3) {
            val r = size.minDimension * 0.22f * i
            drawArc(
                color = color,
                startAngle = 225f,
                sweepAngle = 90f,
                useCenter = false,
                topLeft = Offset(cx - r, cy - r),
                size = Size(r * 2, r * 2),
                style = Stroke(width = stroke, cap = StrokeCap.Round)
            )
        }
        drawCircle(color = color, radius = stroke * 0.9f, center = Offset(cx, cy))
    }
}