# SPEC-005 — Persistência Local: histórico de verificações

**Sprint:** 05 — Local Persistence & Data
**Equipe:** Team 03 — Wiflux
**Pré-requisitos:** Sprints 01 a 04 funcionando

## 1. O que precisa persistir

| Pergunta | Resposta |
| --- | --- |
| O que é guardado? | Cada verificação feita: nome do cômodo, status (Sinal Forte/Médio/Fraco) e data/hora |
| Por que persistir? | O objetivo do Wiflux é comparar o sinal entre cômodos. Sem persistência, tudo se perde ao fechar o app |
| Quando grava? | Ao tocar em "Iniciar Verificação" com nome de cômodo válido (mín. 3 letras, Sprint 04) |
| Quando lê? | Ao abrir a Home; a lista se atualiza automaticamente a cada novo registro |
| Como o usuário vê? | Card "Últimas verificações" no fim da Home, com as 5 mais recentes |

## 2. Mecanismo escolhido

**Room.** São registros estruturados que crescem com o uso (um por verificação), então Room é adequado.
DataStore serve para valores pequenos de preferência (tema, flag) e não para uma lista de registros.

## 3. Modelo de dados

Tabela `verifications`:

| Campo | Tipo | Descrição |
| --- | --- | --- |
| id | Int (PK, autoincrement) | Identificador |
| roomName | String | Nome do cômodo informado no formulário |
| status | String | Nome do enum `SignalStatus`: STRONG, MEDIUM ou WEAK |
| createdAt | Long | Data/hora em milissegundos |

Operações: `insert` (salvar) e `getAll` (ler, mais recente primeiro, via Flow).

## 4. Requisitos funcionais

- **FR-01** — Ao tocar em "Iniciar Verificação" com nome válido, o app salva um registro no banco.
- **FR-02** — Verificação com nome inválido (menos de 3 letras) não é salva.
- **FR-03** — A Home exibe as 5 verificações mais recentes (nome, status, data/hora).
- **FR-04** — Os registros continuam disponíveis após fechar e reabrir o app.
- **FR-05** — Sem registros, a Home mostra "Nenhuma verificação salva ainda".

## 5. Critérios de aceite

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

## 6. Fora do escopo

Editar ou excluir registros, mapa visual por cômodo, DataStore/preferências, sincronização em nuvem.
