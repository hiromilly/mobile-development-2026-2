# SPEC-005 — Persistência Local: histórico de verificações

**Sprint:** 05 — Local Persistence & Data
**Equipe:** Team 03 — Wiflux (Célia Hiromi e Geovanna Gaspar)
**Pré-requisitos:** Sprints 01 a 04 funcionando

## 1. Contexto

Até a Sprint 04, o Wiflux valida o nome do cômodo e mostra o status do sinal, mas tudo fica só na memória da tela: ao fechar o app, as verificações se perdem. Como o objetivo do produto é comparar o sinal entre cômodos, o usuário precisa rever verificações anteriores.

### O que precisa persistir

| Pergunta | Resposta |
| --- | --- |
| O que é guardado? | Cada verificação feita: nome do cômodo, status (Sinal Forte/Médio/Fraco) e data/hora |
| Por que persistir? | O objetivo do Wiflux é comparar o sinal entre cômodos. Sem persistência, tudo se perde ao fechar o app |
| Quando grava? | Ao tocar em "Iniciar Verificação" com nome de cômodo válido (mín. 3 letras, Sprint 04) |
| Quando lê? | Ao abrir a Home; a lista se atualiza automaticamente a cada novo registro |
| Como o usuário vê? | Card "Últimas verificações" no fim da Home, com as 5 mais recentes |

## 2. Objetivo

Salvar cada verificação válida em um banco local (Room) e exibir as 5 mais recentes na Home, mantendo os dados após fechar e reabrir o app.

## 3. Cenário do Usuário

**Dado** que o usuário digitou "sala" e tocou em "Iniciar Verificação",
**quando** ele fecha o app pelo multitarefa e o abre de novo,
**então** o card "Últimas verificações" ainda mostra "sala", o status e a data/hora.

## 4. Requisitos Funcionais

- **FR-01** — Ao tocar em "Iniciar Verificação" com nome válido, o app salva um registro no banco.
- **FR-02** — Verificação com nome inválido (menos de 3 letras) não é salva.
- **FR-03** — A Home exibe as 5 verificações mais recentes (nome, status, data/hora).
- **FR-04** — Os registros continuam disponíveis após fechar e reabrir o app.
- **FR-05** — Sem registros, a Home mostra "Nenhuma verificação salva ainda".

## 5. Restrições

### Tecnologias Obrigatórias

Kotlin, Jetpack Compose, Room (runtime, ktx e compiler via KSP), ViewModel (`lifecycle-viewmodel-compose`) e Flow.

### Mecanismo escolhido

**Room.** São registros estruturados que crescem com o uso (um por verificação), então Room é adequado.
DataStore serve para valores pequenos de preferência (tema, flag) e não para uma lista de registros.

### Restrições do Projeto

- Todo o trabalho fica em `projects/team-03/`.
- A tela não acessa o Room diretamente: passa pelo `HistoryViewModel`.

### Arquivos que Não Devem Ser Modificados

`DetailsScreen.kt` e a pasta `ui/theme/`.

## 6. Fora do Escopo

Editar ou excluir registros, mapa visual por cômodo, DataStore/preferências, sincronização em nuvem.

## 7. Critérios de Aceite

- **AC-01** — SPEC-005 existe.
- **AC-02** — Room foi escolhido e justificado.
- **AC-03** — A entidade `Verification` modela os dados necessários.
- **AC-04** — Uma nova verificação é salva (FR-01, FR-02).
- **AC-05** — Os dados são lidos e exibidos na Home (FR-03, FR-05).
- **AC-06** — Os registros sobrevivem à reinicialização do app (FR-04).
- **AC-07** — Sprints 01 a 04 continuam funcionando (medidor, chip, navegação e validação).
- **AC-08** — O app compila sem erros.
- **AC-09** — Evidências `data-created.png` e `data-restored.png` existem.
- **AC-10** — A equipe sabe explicar o fluxo de dados.

## 8. Rastreabilidade

| FR | AC | Onde está no código |
| --- | --- | --- |
| FR-01 | AC-04 | `HomeScreen` → `onSave` → `HistoryViewModel.save()` → `VerificationDao.insert()` |
| FR-02 | AC-04 | `HomeScreen`: `onSave` só é chamado se `roomName.trim().length >= 3` |
| FR-03 | AC-05 | `VerificationDao.getAll()` → `HistoryViewModel.history` → `HistoryList` (`take(5)`) |
| FR-04 | AC-06 | Banco `wiflux.db` gravado em disco pelo Room (`AppDatabase`) |
| FR-05 | AC-05 | `HistoryList`: `if (items.isEmpty())` |

## 9. Plano de Implementação

### Componentes Criados ou Modificados

| Arquivo | Responsabilidade |
| --- | --- |
| `data/Verification.kt` | Entity: tabela `verifications` |
| `data/VerificationDao.kt` | DAO: `insert` e `getAll` (Flow, mais recente primeiro) |
| `data/AppDatabase.kt` | Cria o banco `wiflux.db` (instância única) |
| `data/HistoryViewModel.kt` | Liga a UI ao banco |
| `HistoryList.kt` | Card com as 5 últimas verificações |
| `MainActivity.kt` | Cria o ViewModel e passa `history` e `onSave` para a Home |
| `HomeScreen.kt` | Chama `onSave` após validar; exibe `HistoryList` |
| `libs.versions.toml` / `build.gradle.kts` | Room 2.8.4, KSP 2.3.6, lifecycle-viewmodel-compose |

### Fluxo de Interação Esperado

- **Salvar:** nome válido → status sorteado → `onSave(nome, status)` → `HistoryViewModel.save()` → `viewModelScope.launch` → `dao.insert()`.
- **Ler:** `dao.getAll()` (Flow) → `history` (StateFlow) → `collectAsState()` → `HistoryList`. A tela recompõe sozinha a cada inserção.

### Dados Necessários

Tabela `verifications`:

| Campo | Tipo | Descrição |
| --- | --- | --- |
| id | Int (PK, autoincrement) | Identificador |
| roomName | String | Nome do cômodo informado no formulário |
| status | String | Nome do enum `SignalStatus`: STRONG, MEDIUM ou WEAK |
| createdAt | Long | Data/hora em milissegundos |

## 10. Plano de Validação

1. Nome com menos de 3 letras → erro aparece e nada é salvo.
2. Verificar "sala" e "quarto" → os dois aparecem no card (`data-created.png`).
3. Fechar o app pelo multitarefa e reabrir → os registros continuam (`data-restored.png`).
4. Tocar em "Ver Detalhes" e voltar → a navegação continua funcionando.
5. Build sem erros no Android Studio.

## 11. Resultados da Validação

| AC | Resultado | Observação |
| --- | --- | --- |
| AC-01 | PASS | SPEC-005 existe |
| AC-02 | PASS | Room escolhido e justificado (seção 5) |
| AC-03 | PASS | Entidade `Verification` |
| AC-04 | PASS | `data-created.png`; nome inválido não salva (verificado no código: `onSave` só no `else` da validação) |
| AC-05 | PASS | Card exibe os registros (`data-created.png`) |
| AC-06 | PASS | `data-restored.png` |
| AC-07 | A confirmar | Home só ganhou `onSave` e `HistoryList`; testar "Ver Detalhes" e Voltar no aparelho |
| AC-08 | PASS | `Assemble Project` sem erros (09/11/2026, Android Studio Quail 3 2026.1.3) |
| AC-09 | PASS | Os dois prints existem |
| AC-10 | A confirmar | Equipe explica o fluxo (seções 4 e 5 do `SPRINT-05.md`) |

**Ambiente:** teste de reinício feito pela Geovanna Gaspar em 07/11/2026 (aparelho a informar). Build conferido em 09/11/2026 no Android Studio Quail 3 2026.1.3.

## 12. Evidências

- `evidence/sprint-05/data-created.png`
- `evidence/sprint-05/data-restored.png`

## 13. Desenvolvimento com Apoio de IA

Ferramenta: Claude (Anthropic). Uso: comparação Room × DataStore, modelagem Entity/DAO/Database e organização com ViewModel. Revisão humana: a equipe revisou, testou no emulador e consegue explicar cada arquivo. Detalhamento completo no `SPRINT-05.md`.

## 14. Prompt Sugerido para Apoio de IA

```text
We are developing an Android application with Kotlin and Jetpack Compose.
Current Sprint: SPRINT-05 (Local Persistence & Data).
Current requirement: FR-01 to FR-05 — Save each valid verification (room name, status and timestamp) in a local Room database when the user taps "Iniciar Verificação", and show the 5 most recent ones in a "Últimas verificações" card on HomeScreen, keeping them after the app is closed and reopened. Invalid names (fewer than 3 letters) must not be saved.
Current code/context: HomeScreen.kt with the validated "Nome do cômodo" field, SignalStatus state and the "Iniciar Verificação" Button; MainActivity.kt with the NavHost. Persistence code must stay outside the button's onClick (Entity + DAO + Database + ViewModel).

Help us implement or review this requirement.
1. Explain the concept first (Entity, DAO, Database, Flow, ViewModel).
2. Propose the smallest change that satisfies the requirement.
3. Explain every relevant part of the suggested code.
4. Identify possible errors or edge cases (e.g., invalid name, empty list, app restart).
5. Tell us how to validate the result in Android Studio.
Do not add functionality outside the current Sprint scope (no edit/delete, no DataStore, no cloud sync).
```

## 15. Deliverables

`app/`, `SPRINT-05.md`, `docs/specs/SPEC-005.md`, `evidence/sprint-05/data-created.png`, `evidence/sprint-05/data-restored.png`.

## 16. Status da Especificação

Aprovada pela equipe — implementação em validação.
