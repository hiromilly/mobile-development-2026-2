# SPEC-002 — Verificação de Sinal (Estado e Interação)

## Context
A tela inicial do Wi-Fi Mapper (SPEC-001) é estática. Esta especificação
introduz estado e interação: o usuário deve poder iniciar uma verificação
de sinal e ver o resultado refletido visualmente na tela.

## Task
Implementar uma interação com estado em Jetpack Compose: ao tocar em um
botão, o app atualiza um valor de estado que representa o status do
sinal Wi-Fi, e a interface reage automaticamente a essa mudança.

## Functional Requirements
- FR-01: A tela deve manter um estado (`signalStatus`) representando o
  status atual do sinal.
- FR-02: O estado inicial deve ser "Aguardando" (nenhuma verificação
  realizada).
- FR-03: Ao tocar no botão "Iniciar Verificação", o estado deve ser
  atualizado para um novo valor (Forte, Médio ou Fraco).
- FR-04: A UI deve refletir visivelmente a mudança de estado (cor,
  texto e valor em dBm exibidos).

## Constraints
- Não há leitura real de RSSI via `WifiManager` nesta Sprint — o valor
  é simulado (sorteado) a cada clique.
- Não há navegação entre telas, persistência de dados nem chamadas de
  rede/API externas.

## Acceptance Criteria
- AC-01 — O app possui uma variável de estado (`signalStatus`).
- AC-02 — O clique no botão altera o valor do estado.
- AC-03 — A UI (radar, texto em dBm, chip de status) muda visivelmente
  conforme o estado.
- AC-04 — O estado inicial ("Aguardando") é exibido corretamente antes
  de qualquer interação.
- AC-05 — A funcionalidade da Sprint 01 (nome, slogan, botão) continua
  funcionando.
- AC-06 — O app builda e roda sem crashes.

## Validation
1. Rodar o app no emulador antes de qualquer clique — capturar
   `before-interaction.png` com o estado "Aguardando".
2. Tocar no botão "Iniciar Verificação".
3. Capturar `after-interaction.png` com o novo estado exibido.
4. Repetir o clique algumas vezes para confirmar que o app não trava e
   que o estado muda de forma consistente.

## AI Usage
Uso de LLM (Claude e Base44) para revisar o código e ajudar com o novo design. Ver tabela detalhada em
`SPRINT-02.md`.

## Out of Scope
- Leitura real de sinal Wi-Fi via `WifiManager`.
- Mapeamento por cômodo/persistência de dados.
- Navegação entre múltiplas telas.

## Deliverables
- `projects/team-03/app/` (código atualizado)
- `projects/team-03/SPRINT-02.md`
- `projects/team-03/docs/specs/SPEC-002.md`
- `projects/team-03/evidence/sprint-02/before-interaction.png`
- `projects/team-03/evidence/sprint-02/after-interaction.png`
