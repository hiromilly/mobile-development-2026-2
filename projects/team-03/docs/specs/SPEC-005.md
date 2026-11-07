# SPEC-005 — Salvar a Última Medição (Persistência Local com Room)

> **Equipe:** Team 03  
> **Integrantes:** Célia Hiromi (@hiromilly) e Geovanna Gaspar (@gegwspar)  
> **Sprint:** SPRINT 05 — Local Persistence & Data  
> **Status:** Em andamento  
> **Documento da Sprint:** [`SPRINT-05.md`](../../SPRINT-05.md)  

---

## 1. Contexto

**Problema:**  
Até a Sprint 04, a medição do **Wiflux** ficava só na memória da tela. Quando o usuário fechava o aplicativo, o cômodo e o resultado eram perdidos.

**Usuário / Ator:**  
Pessoas que verificam o sinal Wi-Fi nos cômodos de casa ou do trabalho.

**Contexto de Uso:**  
O usuário digita o cômodo, toca em **"▶ Iniciar Verificação"** e a medição é salva no celular. Quando abrir o app de novo, verá a **"Última medição salva"**.

---

## 2. Objetivo

O objetivo desta funcionalidade é salvar cada medição válida em um banco de dados local (**Room**) e mostrar a última medição na `HomeScreen`, mesmo depois de fechar e reabrir o aplicativo.

---

## 3. Cenários do Usuário (User Scenarios)

### Cenário 1: Salvar uma medição
**Dado** que o usuário digitou `"Quarto"`,  
**Quando** tocar em **"▶ Iniciar Verificação"**,  
**Então** o dial mostra o sinal (ex: `-45 dBm` / `Sinal Forte`) e o card **"Última medição salva"** passa a mostrar `Quarto · Sinal Forte · -45 dBm` com data e hora.

### Cenário 2: Medição continua após reiniciar
**Dado** que existe uma medição salva,  
**Quando** o usuário fechar o app no multitarefa e abrir de novo,  
**Então** o card mostra a mesma medição.

### Cenário 3: Nada salvo ainda
**Dado** que nenhuma medição foi feita,  
**Quando** o usuário abrir o app,  
**Então** o card mostra **"Nenhuma medição salva ainda"**.

---

## 4. Requisitos Funcionais e Modelo de Dados

### O que precisa ser salvo

| Pergunta | Resposta |
| :--- | :--- |
| **O que é salvo?** | Cômodo, status do sinal, dBm e data/hora da medição. |
| **Por que salvar?** | Para o usuário consultar o resultado depois de fechar o app. |
| **Quando salva?** | Ao tocar em "▶ Iniciar Verificação" com um nome válido. |
| **Quando lê?** | Ao abrir a `HomeScreen`. |
| **Como o usuário vê?** | No card "Última medição salva". |

### Tabela `DiagnosticEntity`

| Campo | Tipo | Exemplo |
| :--- | :--- | :--- |
| `id` | `Int` (gerado automaticamente) | `1` |
| `roomName` | `String` | `"Quarto"` |
| `status` | `String` | `"Sinal Forte"` |
| `dbm` | `Int` | `-45` |
| `timestamp` | `Long` (data/hora em milissegundos) | `1793975520000` |

### FR-01 — Salvar a medição
Ao tocar em **"▶ Iniciar Verificação"** com nome válido, o app deve salvar uma `DiagnosticEntity` no banco Room. Se o nome for inválido (regra da SPEC-004), nada é salvo.

### FR-02 — Ler a última medição
O app deve buscar no banco a medição mais recente (`getLastDiagnostic()`).

### FR-03 — Mostrar o card
A `HomeScreen` deve mostrar o card **"Última medição salva"** com cômodo, status, dBm e data/hora. Sem medições, mostra **"Nenhuma medição salva ainda"**.

### FR-04 — Manter após reiniciar
A última medição deve continuar aparecendo depois que o app for fechado e reaberto.

---

## 5. Restrições Técnicas (Constraints)

### Tecnologias Obrigatórias
- Kotlin
- Jetpack Compose (Material 3)
- Room + KSP
- Android Studio

### Restrições do Projeto
- **Por que Room?** As medições são registros com vários campos (um histórico). A Sprint 05 indica Room para esse tipo de dado. DataStore serve para configurações simples, como tema.
- **Código separado da tela:** os arquivos do banco ficam no pacote `com.team03.wifi.data`. O botão apenas pede para salvar.
- Única biblioteca nova: Room (com o plugin KSP).
- Todo o trabalho fica em `projects/team-03/`.

### Arquivos ou Módulos que Não Devem Ser Modificados
- Pastas de outras equipes.
- `SignalStatus.kt` e `DetailsScreen.kt`.

---

## 6. Fora do Escopo (Out of Scope)

- Tela com lista de todas as medições.
- Editar ou apagar medições.
- ViewModel, Repository ou bibliotecas extras.
- Leitura real do Wi-Fi (`WifiManager`), prevista para a Sprint 06.

---

## 7. Critérios de Aceitação (Acceptance Criteria)

### AC-01 — SPEC-005 existe
**Requisito relacionado:** Documentação  
**Condição:** Este arquivo existe em `projects/team-03/docs/specs/SPEC-005.md`.

### AC-02 — Mecanismo adequado escolhido
**Requisito relacionado:** FR-01  
**Condição:** O app usa Room, com justificativa na seção 5.

### AC-03 — Dados modelados
**Requisito relacionado:** FR-01  
**Condição:** `DiagnosticEntity` tem os campos `id`, `roomName`, `status`, `dbm` e `timestamp`.

### AC-04 — Dados são salvos
**Requisito relacionado:** FR-01  
**Condição:** Com `"Quarto"`, a medição é salva. Com `"ab"`, nada é salvo.

### AC-05 — Dados são lidos e exibidos
**Requisito relacionado:** FR-02, FR-03  
**Condição:** O card mostra a última medição ou "Nenhuma medição salva ainda".

### AC-06 — Dados sobrevivem ao reinício
**Requisito relacionado:** FR-04  
**Condição:** Depois de fechar e reabrir o app, o card mostra a mesma medição.

### AC-07 — Funções anteriores continuam funcionando
**Requisito relacionado:** Todos  
**Condição:** Dial, validação "Digite pelo menos 3 letras" e navegação para "Ver Detalhes" funcionam como antes.

### AC-08 — App compila
**Requisito relacionado:** Todos  
**Condição:** Build com `BUILD SUCCESSFUL` e app abrindo no emulador.

### AC-09 — Evidências existem
**Requisito relacionado:** FR-01, FR-04  
**Condição:** `data-created.png` e `data-restored.png` estão em `evidence/sprint-05/`.

### AC-10 — Equipe explica o fluxo
**Requisito relacionado:** Todos  
**Condição:** As integrantes explicam o caminho: botão → salva no Room → banco → card na tela.

---

## 8. Rastreabilidade dos Requisitos (Requirement Traceability)

*(Será completada após a implementação.)*

| Requisito | Implementado Em | Critério de Aceitação | Evidência |
| :--- | :--- | :--- | :--- |
| **FR-01** | `data/DiagnosticEntity.kt`, `data/DiagnosticDao.kt` (`insert`), `HomeScreen.kt` | AC-02, AC-03, AC-04 | `data-created.png` |
| **FR-02** | `data/DiagnosticDao.kt` (`getLastDiagnostic`) | AC-05 | `data-created.png` |
| **FR-03** | `HomeScreen.kt` (card) | AC-05 | `data-created.png` |
| **FR-04** | `data/AppDatabase.kt` (banco no celular) | AC-06 | `data-restored.png` |

---

## 9. Plano de Implementação (Implementation Plan)

### Componentes a Criar ou Modificar
- `libs.versions.toml` e `app/build.gradle.kts`: adicionar Room.
- `data/DiagnosticEntity.kt`: a tabela.
- `data/DiagnosticDao.kt`: os comandos `insert` e `getLastDiagnostic`.
- `data/AppDatabase.kt`: o banco de dados.
- `HomeScreen.kt`: salvar após a medição e mostrar o card.

### Fluxo Esperado
```text
[Usuário digita "Quarto" e toca em "▶ Iniciar Verificação"]
      ↓
[App mede o sinal e salva no Room]
      ↓
[Card "Última medição salva" mostra a medição]
      ↓
[App fechado e reaberto → card continua mostrando a medição]
```

### Dados Necessários
- `DiagnosticEntity`, salva no Room.
- Estados já existentes (`roomName`, `roomError`, `signalStatus`) sem mudanças.

---

## 10. Plano de Validação (Validation Plan)

1. Compilar o projeto.
2. Abrir o app e ver "Nenhuma medição salva ainda".
3. Digitar `"ab"` e confirmar que nada é salvo.
4. Digitar `"Quarto"`, verificar e capturar `data-created.png`.
5. Fechar o app no multitarefa, reabrir e capturar `data-restored.png`.
6. Testar "Ver Detalhes" e "← Voltar".

---

## 11. Resultados da Validação (Validation Results)

*(Será preenchido após os testes.)*

| Critério de Aceitação | Resultado | Observações |
| :--- | :---: | :--- |
| AC-01 a AC-10 | — | — |

### Ambiente Utilizado na Validação
- **Dispositivo:** —
- **Versão do Android / API:** —
- **Resultado do Build:** —
- **Execução do Aplicativo:** —

---

## 12. Evidências (Evidence)

- `evidence/sprint-05/data-created.png`
- `evidence/sprint-05/data-restored.png`

---

## 13. Desenvolvimento com Apoio de IA (AI-Assisted Development)

*(Será preenchido ao final da sprint.)*

---

## 14. Prompt Sugerido para Apoio de IA

```text
We are developing an Android application with Kotlin and Jetpack Compose.
Current Sprint: SPRINT-05 (Local Persistence & Data).
Current requirement: FR-01 to FR-04 — Save each valid Wi-Fi measurement (roomName, status, dbm, timestamp) in a Room table and show the last saved measurement in a card on HomeScreen, surviving app restart.
Current code/context: HomeScreen.kt with roomName validation and signalStatus state.

Help us implement or review this requirement.
1. Explain the concept first.
2. Propose the smallest change that satisfies the requirement.
3. Explain every relevant part of the suggested code.
4. Identify possible errors or edge cases.
5. Tell us how to validate the result in Android Studio.
Do not add functionality outside the current Sprint scope.
```

---

## 15. Entregáveis (Deliverables)

- [ ] Aplicativo Android atualizado (`projects/team-03/app/`)
- [x] `SPEC-005.md`
- [ ] `SPRINT-05.md`
- [ ] `evidence/sprint-05/data-created.png` e `data-restored.png`

---

## 16. Status da Especificação (Specification Status)

- [x] Contexto e objetivo estão claros.
- [x] Requisitos funcionais estão completos.
- [x] Restrições técnicas estão documentadas.
- [x] Itens fora do escopo estão documentados.
- [x] Critérios de aceitação são mensuráveis.
- [ ] Rastreabilidade de requisitos está completa.
- [ ] Implementação satisfaz a especificação.
- [ ] Resultados da validação estão documentados.
- [ ] Evidências visuais estão incluídas.
- [ ] Uso de IA está documentado.
- [ ] Todas as integrantes da equipe sabem explicar a funcionalidade implementada.
