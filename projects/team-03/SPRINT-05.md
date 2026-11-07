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

Dependências adicionadas: Room (runtime, ktx, compiler via KSP) e `lifecycle-viewmodel-compose`.

## 4. Fluxo de salvar

Usuário digita o cômodo → validação (mín. 3 letras) → status é sorteado → `HomeScreen` chama `onSave(nome, status)` → `HistoryViewModel.save()` → `viewModelScope.launch` → `dao.insert()` grava no SQLite.

## 5. Fluxo de ler

`dao.getAll()` retorna um `Flow` → `HistoryViewModel.history` (StateFlow) → `collectAsState()` na `MainActivity` → parâmetro `history` da Home → `HistoryList`. Ao inserir um registro, o Flow emite a lista nova e a tela recompõe sozinha.

## 6. Resultado da reinicialização

Preencher após o teste: criar uma verificação, fechar o app por completo (remover dos recentes), reabrir e confirmar que o registro continua na lista.

- [x] Registro criado (`evidence/sprint-05/data-created.png`)
- [x] Registro restaurado após reiniciar (`evidence/sprint-05/data-restored.png`)

## 7. Uso de LLM

| Item | Resposta da equipe |
| --- | --- |
| LLM/ferramenta usada | Claude (Anthropic) |
| Tarefa apoiada pela LLM | Escolha entre Room e DataStore, modelagem da entidade/DAO/banco e organização do código de dados |
| Principal sugestão recebida | Usar Room com uma única entidade `Verification`, `Flow` no DAO e um `ViewModel` entre a tela e o banco |
| O que a equipe alterou manualmente | Criação dos arquivos e códigos novos. |
| Como o resultado foi validado | Testamos o aplicativo no android Studio e validamos ele. |

## 8. Critérios de aceite

Ver SPEC-005, seção 5. Marcar cada um após validar no emulador/celular.
