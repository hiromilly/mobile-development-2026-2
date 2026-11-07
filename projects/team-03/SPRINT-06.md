# SPRINT 06 — External or Device Integration — Team 03 (Wiflux)

## 1. Integração escolhida e relevância para o produto

Leitura do sinal Wi-Fi do aparelho (RSSI em dBm) com o `WifiManager` do Android. O Wiflux existe para medir a qualidade do Wi-Fi em cada cômodo; até a Sprint 05 o status era um sorteio, e agora vem do sinal real. Detalhes em `docs/specs/SPEC-006.md`.

---

## 2. Fluxo dos dados

Usuário toca em "Iniciar Verificação" → `HomeScreen` valida o nome → `onMeasure` → `MeasureViewModel.measure()` → `WifiReader.read()` (3 vezes) → média em dBm → `classificar()` → `MeasureState.Success(dbm, status)` → a Home mostra o medidor e o chip → `HistoryViewModel.save()` grava no Room (Sprint 05).

| Arquivo | Responsabilidade |
|---|---|
| `data/WifiReader.kt` | Única classe que fala com o `WifiManager`; devolve Success, WifiOff ou NotConnected |
| `data/MeasureViewModel.kt` | Estados da medição (Idle, Loading, Success, Error), 3 leituras, média e classificação |
| `MainActivity.kt` | Cria os dois ViewModels; liga `onMeasure` ao salvamento; rota de detalhes recebe o dBm |
| `HomeScreen.kt` | Mostra loading, sucesso e erro; o medidor usa o dBm real |
| `DetailsScreen.kt` | Recebe o dBm medido (parâmetro novo) |
| `AndroidManifest.xml` | Permissão `ACCESS_WIFI_STATE` |

---

## 3. Comportamento assíncrono

A medição roda dentro de `viewModelScope.launch`. Cada leitura usa `withContext(Dispatchers.IO)` e entre as leituras há `delay(500)`, então a interface não trava. O estado `Loading` desabilita o botão para evitar toques repetidos.

---

## 4. Tratamento de falhas

| Situação | O que o app faz |
|---|---|
| Wi-Fi desligado | `WifiReading.WifiOff` → mensagem em vermelho, nada salvo |
| Ligado, sem rede | `WifiReading.NotConnected` (RSSI inválido, -127) → mensagem em vermelho, nada salvo |
| Exceção inesperada | `try/catch` no ViewModel → mensagem genérica, nada salvo |

---

## 5. Privacidade e segurança

- O app lê só a intensidade do sinal. Não lê nome da rede (SSID), endereço MAC nem localização.
- Nada é enviado pela internet; não há API, chave ou token no projeto.
- Permissão usada: `ACCESS_WIFI_STATE` (normal, sem diálogo).

---

## 6. Validação (preencher após os testes)

- [x] Cenário de sucesso: Wi-Fi conectado, verificar um cômodo, dBm real aparece (`evidence/sprint-06/integration-success.png`)
- [x] Cenário alternativo: Wi-Fi desligado, mensagem de erro aparece (`evidence/sprint-06/integration-alternative-state.png`)
- [x] Sprints anteriores: validação do nome, Ver Detalhes, histórico salvo após reiniciar

---

## 7. Uso de LLM

| Item | Resposta da equipe |
|---|---|
| LLM/ferramenta usada | Claude (Anthropic) |
| Tarefa apoiada pela LLM | Escolha da integração, leitura do Wi-Fi com `WifiManager`, estados de loading/sucesso/erro com coroutines |
| Principal sugestão recebida | Isolar o Android em `WifiReader`, usar um `MeasureViewModel` com estados e tirar a média de 3 leituras |
| O que a equipe alterou manualmente | Criacao de codigos e arquivos novos |
| Como o resultado foi validado | Testes feitos no Android Studio, aplicativo funcionando corretamente |

---

## 8. Critérios de aceite

Ver SPEC-006, seção 5. Marcar cada um após validar no emulador/celular.
