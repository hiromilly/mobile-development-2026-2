# SPEC-001 — Definição do Produto Wi-Fi Mapper e Primeira Tela

> **Equipe:** Team 03  
> **Integrantes:** Célia Hiromi (@hiromilly) e Geovanna Gaspar (@gegwspar)  
> **Sprint:** SPRINT 01  
> **Status:** Validado  
> **Documento da Sprint:** [`SPRINT-01.md`](../../SPRINT-01.md)

---

## 1. Contexto

**Problema:**  
Pessoas que trabalham ou estudam em regime domiciliar dependem diretamente da estabilidade e intensidade da rede Wi-Fi. No entanto, instabilidades e variações na qualidade do sinal causam travamentos em chamadas de vídeo, lentidão em downloads e interrupções frequentes. A maioria dos usuários não consegue diagnosticar se o problema decorre da distância do roteador, de interferências estruturais ou de instabilidade externa da operadora. Os aplicativos existentes no mercado são técnicos em excesso, repletos de gráficos complexos e sobrecarregados de propagandas.

**Usuário / Ator:**  
Estudantes, profissionais em home office e usuários domésticos que desejam diagnosticar a qualidade da sua rede sem precisar de conhecimento técnico aprofundado em redes.

**Contexto de Uso:**  
Ao perceber lentidão ou quedas de sinal em diferentes cômodos da residência ou escritório, o usuário abre o aplicativo para iniciar uma verificação rápida e entender a situação da sua rede.

---

## 2. Objetivo

O objetivo desta especificação é definir formalmente o produto **Wi-Fi Mapper** e implementar a primeira tela da aplicação em Kotlin com Jetpack Compose, contendo a identidade do produto, slogan explicativo, elemento visual representativo de sinal e um botão de ação primária destacado que orienta o início do fluxo de uso.

---

## 3. Cenário do Usuário (User Scenario)

**Dado** que o usuário instalou e abriu o aplicativo **Wi-Fi Mapper** em seu smartphone Android,  
**Quando** a tela inicial for carregada,  
**Então** o usuário deve visualizar claramente o nome da aplicação (**Wi-Fi Mapper**), o slogan *"Encontre os pontos cegos do seu Wi-Fi e melhore sua conexão em qualquer cômodo."*, o container ilustrativo com barras de intensidade de sinal e o botão primário *"Iniciar Verificação de Sinal"*.

---

## 4. Requisitos Funcionais

### RF-01 — Identidade Visual do Produto
A interface da primeira tela deve exibir o nome do aplicativo (**Wi-Fi Mapper**) com tipografia destacada (`fontSize = 32.sp`, `FontWeight.Bold`).

### RF-02 — Slogan e Proposta de Valor
A interface deve apresentar a mensagem textual concisa: *"Encontre os pontos cegos do seu Wi-Fi e melhore sua conexão em qualquer cômodo."* comunicando o objetivo do app de forma clara e acessível.

### RF-03 — Elemento Visual de Sinal
A tela deve apresentar um card centralizado com cantos arredondados contendo uma ilustração temática em barras representando a intensidade do sinal Wi-Fi.

### RF-04 — Botão de Ação Primária
A interface deve disponibilizar um botão de destaque visual com o texto *"Iniciar Verificação de Sinal"*, contendo feedback de toque visual (ripple) ao ser acionado.

---

## 5. Restrições Técnicas

### Tecnologias Obrigatórias:
- **Linguagem:** Kotlin
- **UI Framework:** Jetpack Compose (Material Design 3)
- **IDE:** Android Studio (Ladybug 2024.2.1 ou superior)

### Restrições do Projeto:
- **SDK Mínimo:** API 24 (Android 7.0)
- **SDK Alvo:** API 34+
- **Layouts Legados:** Não utilizar XML layouts para telas de UI.
- **Escopo desta Sprint:** Não utilizar chamadas a APIs de rede externas ou banco de dados nesta etapa.

---

## 6. Fora do Escopo (Out of Scope)

Os seguintes itens não fazem parte do escopo da Sprint 01 e serão abordados em sprints posteriores:
- Coleta de permissões de localização/Wi-Fi em segundo plano (planejado para a Sprint 06).
- Medição e cálculo dinâmico de intensidade de sinal com gráficos (planejado para a Sprint 02).
- Navegação entre múltiplas telas e abas (planejado para a Sprint 03).
- Formulários de cadastro de ambientes e filtros (planejado para a Sprint 04).
- Persistência em banco de dados SQLite/Room (planejado para a Sprint 05).

---

## 7. Critérios de Aceitação

### AC-01 — Nome do Aplicativo Visível
**Requisito relacionado:** RF-01  
**Condição:** Ao abrir a tela, o título **Wi-Fi Mapper** deve estar visível, centralizado e legível com estilo tipográfico de destaque.

### AC-02 — Slogan e Proposta de Valor Acessíveis
**Requisito relacionado:** RF-02  
**Condição:** O texto descritivo do slogan deve estar posicionado abaixo do título, com contraste adequado e tipografia legível.

### AC-03 — Elemento Visual Central Apresentado
**Requisito relacionado:** RF-03  
**Condição:** A interface deve renderizar o container visual com cantos arredondados e as barras de intensidade de sinal.

### AC-04 — Botão de Ação Primária Funcional e Destacado
**Requisito relacionado:** RF-04  
**Condição:** O botão *"Iniciar Verificação de Sinal"* deve estar visível com largura proporcional, cores do tema e feedback visual de clique.

### AC-05 — Compilação e Execução Estável
**Requisitos relacionados:** RF-01, RF-02, RF-03, RF-04  
**Condição:** O aplicativo deve compilar com `./gradlew assembleDebug` e rodar em emuladores Android (API 24+) sem gerar falhas em tempo de execução (*no crash*).

---

## 8. Rastreabilidade dos Requisitos

| Requisito | Implementado Em | Critério de Aceitação | Evidência |
| :--- | :--- | :--- | :--- |
| **RF-01** | `MainActivity.kt` (`WifiMapperHomeScreen`) | AC-01 | `evidence/sprint-01/first-screen.png` |
| **RF-02** | `MainActivity.kt` (`WifiMapperHomeScreen`) | AC-02 | `evidence/sprint-01/first-screen.png` |
| **RF-03** | `MainActivity.kt` (`WifiMapperHomeScreen`) | AC-03 | `evidence/sprint-01/first-screen.png` |
| **RF-04** | `MainActivity.kt` (`WifiMapperHomeScreen`) | AC-04 | `evidence/sprint-01/first-screen.png` |

---

## 9. Plano de Implementação

### Componentes Criados/Modificados:
- `MainActivity.kt`: Implementação do Composable `WifiMapperHomeScreen` com `Scaffold`, `Column`, `Box`, `Row`, `Text`, `Button` e espaçamentos com `Arrangement.SpaceEvenly`.
- `Theme.kt`: Ajuste das cores e tipografia do Material Design 3.

### Fluxo de Interação Previsto:
```text
[Abertura do App]
      ↓
[Visualização do Nome, Slogan e Ilustração de Sinal]
      ↓
[Toque no Botão "Iniciar Verificação de Sinal"]
      ↓
[Feedback Visual de Toque (Ripple)]
```

---

## 10. Resultados da Validação

| Critério | Resultado | Observações |
| :--- | :--- | :--- |
| **AC-01** | **PASS** | Título "Wi-Fi Mapper" renderizado com destaque e alinhamento central. |
| **AC-02** | **PASS** | Slogan *"Encontre os pontos cegos do seu Wi-Fi..."* legível e centralizado. |
| **AC-03** | **PASS** | Container visual de intensidade de sinal com cantos arredondados renderizado. |
| **AC-04** | **PASS** | Botão primário *"Iniciar Verificação de Sinal"* estilizado e responsivo ao toque. |
| **AC-05** | **PASS** | Projeto compilando e executando sem crash no emulador Android. |

### Ambiente de Validação:
- **Dispositivo:** Emulador Android (Google Pixel 8)
- **Versão do Android:** API 34 (Android 14)
- **Resultado do Build:** PASS
- **Execução do App:** PASS

---

## 11. Evidência de Validação

- **Evidência Visual:** `projects/team-03/evidence/sprint-01/first-screen.png`
- **Referência no Documento da Sprint:** [`SPRINT-01.md`](../../SPRINT-01.md#4-validação-e-evidência)

---

## 12. Desenvolvimento com Apoio de IA

- **Ferramenta Utilizada:** Antigravity AI / Gemini 3.7 Flash
- **Uso:** Auxílio na estruturação dos requisitos funcionais, critérios de aceitação e arquitetura da interface com Jetpack Compose.
- **Revisão Humana:** Validação e adaptação de todos os textos para o contexto em português do **Wi-Fi Mapper** e verificação de compatibilidade com o Material Design 3.

---

## 13. Status da Especificação

- [x] Contexto e objetivo definidos com foco na dor real do usuário.
- [x] Requisitos funcionais completos e observáveis.
- [x] Restrições técnicas e fora de escopo explicitados.
- [x] Critérios de aceitação mensuráveis e testáveis.
- [x] Matriz de rastreabilidade de requisitos preenchida.
- [x] Validação executada e documentada.
- [x] Todas as integrantes compreendem a especificação e a implementação.
