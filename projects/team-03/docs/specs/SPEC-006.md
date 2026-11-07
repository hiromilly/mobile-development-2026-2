# SPEC-006 — Integração com o dispositivo: leitura real do sinal Wi-Fi

**Sprint:** 06 — External or Device Integration
**Equipe:** Team 03 — Wiflux
**Pré-requisitos:** Sprints 01 a 05 funcionando

## 1. Fronteira da integração

| Pergunta | Resposta |
| --- | --- |
| Qual capacidade é usada? | Wi-Fi do aparelho, via `WifiManager` do Android |
| Por que o produto precisa? | O objetivo do Wiflux é medir o sinal por cômodo. Até a Sprint 05 o status era sorteado; agora vem do sinal real |
| O que o app pede? | Se o Wi-Fi está ligado e a intensidade (RSSI, em dBm) da conexão atual |
| O que recebe? | Um número em dBm (ex.: -58), ou a informação de que não há leitura possível |
| O que pode falhar? | Wi-Fi desligado; Wi-Fi ligado sem rede Wi-Fi ativa (inclui estar usando dados móveis); erro inesperado na leitura |
| O app envia algo para fora? | Não. Nada sai do aparelho |

## 2. Permissão

`ACCESS_WIFI_STATE` e `ACCESS_NETWORK_STATE` são permissões normais (concedidas na instalação). Não há diálogo para o usuário, então não existe estado "permissão negada". O app não lê nome da rede (SSID) nem localização, que exigiriam permissão de localização.

## 3. Comportamento

1. O usuário digita o nome do cômodo e toca em "Iniciar Verificação" (validação da Sprint 04 continua valendo).
2. **Loading:** o botão fica desabilitado com o texto "Medindo sinal..." e o chip mostra "Medindo...".
3. O app faz 3 leituras com 0,5 s entre elas (em segundo plano) e calcula a média, pois o sinal oscila.
4. **Sucesso:** o medidor mostra o dBm real e o status é classificado (regra abaixo); a verificação é salva no histórico (Sprint 05).
5. **Falha:** mensagem em vermelho abaixo do botão; nada é salvo no histórico.

### Classificação

| dBm médio | Status |
| --- | --- |
| maior ou igual a -60 | Sinal Forte |
| de -61 a -75 | Sinal Médio |
| menor que -75 | Sinal Fraco |

## 4. Requisitos funcionais

- **FR-01** — Com nome válido, "Iniciar Verificação" dispara a leitura do Wi-Fi.
- **FR-02** — Durante a leitura, o botão fica desabilitado e a tela indica que está medindo.
- **FR-03** — Em caso de sucesso, a Home mostra o dBm real e o status correspondente.
- **FR-04** — "Ver Detalhes" mostra o mesmo dBm medido.
- **FR-05** — Wi-Fi desligado mostra "Wi-Fi desligado. Ative o Wi-Fi para medir." e não salva registro.
- **FR-06** — Wi-Fi ligado sem conexão mostra "Sem conexão Wi-Fi. Conecte-se a uma rede para medir." e não salva registro.
- **FR-07** — Erro inesperado mostra "Não foi possível ler o sinal do Wi-Fi." e não salva registro.

## 5. Critérios de aceite

- **AC-01** — SPEC-006 existe.
- **AC-02** — A leitura do Wi-Fi é relevante para o objetivo do produto (medir sinal por cômodo).
- **AC-03** — O app dispara a integração pelo botão "Iniciar Verificação".
- **AC-04** — O resultado real (dBm e status) aparece na tela (FR-03, FR-04).
- **AC-05** — Pelo menos um estado alternativo é tratado: Wi-Fi desligado e sem conexão (FR-05, FR-06).
- **AC-06** — Nenhum segredo (chave de API, token, senha) existe no repositório.
- **AC-07** — Sprints 01 a 05 continuam funcionando (navegação, validação do nome, histórico no Room).
- **AC-08** — O app compila e roda.
- **AC-09** — Evidências `integration-success.png` e `integration-alternative-state.png` existem.
- **AC-10** — A equipe sabe explicar o fluxo da integração.

## 6. Fora do escopo

Nome da rede (SSID), varredura de redes próximas, localização, mapa, gravar o dBm no banco, medição contínua em tempo real.
