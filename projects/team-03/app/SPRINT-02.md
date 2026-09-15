# SPRINT 02 — State & User Interaction

## Interação Escolhida

Ao tocar no botão "Iniciar Verificação", o app simula uma leitura de sinal
Wi-Fi e atualiza visualmente o resultado: o valor em dBm exibido no centro
do radar, o setor colorido desenhado no radar e o chip de status
("Aguardando" → "Sinal Forte" / "Sinal Médio" / "Sinal Fraco").

## Estado Introduzido

- Variável de estado: `signalStatus`, do tipo `SignalStatus` (enum),
  gerenciada com `remember { mutableStateOf(SignalStatus.NONE) }`.
- Estado inicial: `SignalStatus.NONE` — nenhuma verificação realizada.
- Cada valor do enum carrega um `label`, uma `color` e um valor simulado
  de `dbm`, usados diretamente na renderização da UI.

## Evento que Altera o Estado

O clique no botão "Iniciar Verificação" (`onClick`) sorteia aleatoriamente
um dos valores `STRONG`, `MEDIUM` ou `WEAK` e atribui à variável
`signalStatus`.

## UI que Reage ao Estado

- O `Canvas` do radar (`RadarView`) desenha um setor colorido apenas
  quando `status != SignalStatus.NONE`, usando a cor do estado atual.
- O texto central do radar mostra o valor em dBm do estado atual.
- O ícone/emoji do radar muda de cor conforme o estado.
- O chip abaixo do radar mostra `signalStatus.label` com a cor
  correspondente.

## Requisitos e Critérios Validados

- FR/AC referentes à existência de estado, evento alterando o estado e
  UI reagindo visivelmente foram cumpridos (ver SPEC-002).
- A funcionalidade da Sprint 01 (nome do app, slogan, botão) foi
  preservada e está integrada ao novo layout.

## Uso de LLM

| Item | Resposta da equipe |
| --- | --- |
| LLM/tool usado | Claude |
| Tarefa apoiada pela LLM | Implementação do estado (`SignalStatus`), do evento no botão e da UI reativa (radar em Canvas); correção de erro de dependência dos ícones do Material |
| Principal sugestão recebida | Uso de `enum class SignalStatus` para representar os estados possíveis do sinal, com `remember`/`mutableStateOf` conectando o clique do botão à atualização visual |
| O que a equipe alterou manualmente | O design do aplicativo foi totalmente alterado. |
| Como o resultado foi validado | Build e execução no emulador Pixel 6 (API 34); verificação visual do estado antes e depois do clique, conforme evidências |

## Regressão

Confirmado que a Sprint 01 continua funcionando: nome do app, slogan e
botão de ação seguem visíveis e funcionais dentro da nova tela.
