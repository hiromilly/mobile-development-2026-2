# SPRINT 05 — Local Persistence & Data — Team 03 (Wiflux)

## 1. O que precisa persistir

Histórico de verificações (nome do cômodo, status, data/hora). Grava ao tocar em "Iniciar Verificação" com nome válido; lê ao abrir a Home; o usuário vê no card "Últimas verificações". Detalhes em `docs/specs/SPEC-005.md`.

## 2. Mecanismo escolhido e motivo

**Room.** Os dados são registros estruturados e a lista cresce a cada verificação. DataStore é indicado para preferências pequenas (tema, flag de onboarding), o que não é o caso aqui.

## 3. Modelo de dados

Entidade `Verification` (tabela `verifications`): `id` (PK autoincrement), `roomName`, `status`, `createdAt`.

| Arquivo | Responsabilidade |
| --- | --- |
| `data/Verification.kt` | Entity: define a tabela |
| `data/VerificationDao.kt` | DAO: `insert` e `getAll` |
| `data/AppDatabase.kt` | Cria o banco `wiflux.db` (instância única) |
| `data/HistoryViewModel.kt` | Liga a UI ao banco, sem Room dentro da tela |
| `HistoryList.kt` | Composable que mostra as 5 últimas verificações |
| `MainActivity.kt` | Cria o ViewModel e passa `history` e `onSave` para a Home |
| `HomeScreen.kt` | Chama `onSave` após validar e sortear; exibe `HistoryList` |

Dependências: Room 2.8.4 (runtime, ktx, compiler via KSP 2.3.6) e `lifecycle-viewmodel-compose`.

## 4. Fluxo de salvar

Usuário digita o cômodo → validação (mín. 3 letras) → status é sorteado → `HomeScreen` chama `onSave(nome, status)` → `HistoryViewModel.save()` → `viewModelScope.launch` → `dao.insert()` grava no SQLite.

## 5. Fluxo de ler

`dao.getAll()` retorna um `Flow` → `HistoryViewModel.history` (StateFlow) → `collectAsState()` na `MainActivity` → parâmetro `history` da Home → `HistoryList`. Ao inserir um registro, o Flow emite a lista nova e a tela recompõe sozinha.

## 6. Resultado da reinicialização

Código e prints entregues pela Geovanna Gaspar (teste em 07/11/2026). Foram criadas duas verificações ("sala" e "quarto"), o app foi fechado por completo e reaberto. Ao reabrir, a tela voltou ao estado inicial (medidor "Aguardando", campo vazio) e o card "Últimas verificações" continuou mostrando os dois registros com a data/hora originais.

- [x] Registro criado (`evidence/sprint-05/data-created.png`)
- [x] Registro restaurado após reiniciar (`evidence/sprint-05/data-restored.png`)

## 7. Uso de LLM

| Item | Resposta da equipe |
| --- | --- |
| LLM/ferramenta usada | Claude (Anthropic), em chat e no Claude Code |
| Tarefa apoiada pela LLM | Escolha entre Room e DataStore; modelagem de Entity/DAO/Database; organização com ViewModel; revisão do Git e conferência entre a documentação e o código antes do commit |
| Principal sugestão recebida | Room com uma única entidade `Verification`, `Flow` no DAO e um `ViewModel` entre a tela e o banco; manter `rememberSaveable` na Home |
| O que a equipe alterou manualmente | Decidiu manter o código da Geovanna em vez do `DiagnosticEntity` inicial e removeu os arquivos `Diagnostic*`; manteve o medidor redesenhado; restaurou `rememberSaveable` na `HomeScreen` para preservar a validação da Sprint 04; descartou arquivos de projeto-modelo criados por engano pelo Android Studio |
| Como o resultado foi validado | Geovanna executou o app no Android Studio (criar, fechar e reabrir), registrado nos dois prints. O build foi conferido pela equipe em 09/11/2026 com `Assemble Project`, sem erros |

## 8. Critérios de aceite

Ver SPEC-005, seção 7. Resultado de cada um na seção 11 da SPEC.
