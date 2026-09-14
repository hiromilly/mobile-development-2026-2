# SPRINT 01 — Definição do Produto e Primeira Tela

> **Disciplina:** Desenvolvimento de Software Móvel (2026.2)  
> **Equipe:** Team 03  
> **Integrantes:** Célia Hiromi (@hiromilly) e Geovanna Gaspar (@gegwspar)  
> **Ciclo de Desenvolvimento:** `SPEC → BUILD → VALIDATE → EXPLAIN → COMMIT`  
> **Prazo Oficial:** 14/09/2026  

---

## 1. Definição do Produto

### 📘 [GUIA DO TÓPICO: O que o professor avalia aqui?]
> O professor exige que o produto parta de uma **dor real do usuário**, e não apenas da tecnologia.  
> ❌ *Exemplo fraco:* "Vamos fazer um app de Wi-Fi com Jetpack Compose."  
>  *Exemplo forte:* Descrever a dificuldade que as pessoas têm com quedas de sinal, instabilidade ou dificuldade para entender a qualidade da conexão em casa ou no trabalho.

### 💡 [SUGESTÃO DE TEXTO PARA O PROJETO WIFI]:
- **Nome do Produto:** **WifiPulse** *(ou WifiMaster / WifiCheck)*
- **Declaração do Problema:**  
  Usuários domésticos e profissionais em regime de *home office* frequentemente sofrem com quedas inesperadas de internet e lentidão durante reuniões ou estudos, tendo dificuldade em identificar se o problema é o sinal fraco do roteador em determinado cômodo ou uma falha de conexão externa. Os aplicativos tradicionais de análise de rede disponíveis são excessivamente técnicos, poluídos de anúncios e complexos para o usuário comum.
- **Público-Alvo:**  
  Estudantes, trabalhadores remotos e usuários comuns que necessitam diagnosticar e acompanhar a estabilidade da sua rede Wi-Fi residencial ou de trabalho de forma rápida, intuitiva e sem jargões incompreensíveis.
- **Objetivo do Produto:**  
  Oferecer uma ferramenta móvel minimalista, clara e direta para verificar o status da rede Wi-Fi, monitorar a intensidade do sinal nos cômodos e orientar o usuário sobre a qualidade da sua conexão em tempo real.
- **Funcionalidades Iniciais Planejadas:**
  1. *Sprint 01:* Tela inicial de boas-vindas com identificação da marca, status visual da rede e botão de diagnóstico rápido.
  2. *Sprint 02:* Indicador interativo do sinal de Wi-Fi com atualização reativa via clique.
  3. *Sprint 03:* Navegação entre a tela principal e a tela de detalhes da rede/configurações.
  4. *Sprint 04:* Formulário para testar velocidade esperada e registrar limites de alerta de sinal fraco com validação.
  5. *Sprint 05:* Histórico persistido localmente no Room com os registros de medição e locais testados.
  6. *Sprint 06:* Integração com API de informações de rede ou leitura nativa dos dados do adaptador Wi-Fi do Android.

---

## 2. Especificação Técnica (SPEC-001)

### 📘 [GUIA DO TÓPICO]
> Deve haver um arquivo formal em `projects/team-03/docs/specs/SPEC-001.md` definindo os Requisitos Funcionais (RF) e Critérios de Aceitação (AC) mensuráveis.

### 💡 [SUGESTÃO DE TEXTO PARA O PROJETO WIFI]:
- **Arquivo da Especificação:** [`docs/specs/SPEC-001.md`](docs/specs/SPEC-001.md)
- **Requisitos Funcionais Atendidos nesta Sprint:**
  - **RF-01:** O aplicativo deve exibir o nome do produto (**WifiPulse**) com tipografia destacada e logotipo/ícone representativo.
  - **RF-02:** O aplicativo deve apresentar um slogan claro e conciso sobre a finalidade da ferramenta (*"Monitore e otimize a estabilidade da sua conexão Wi-Fi"*).
  - **RF-03:** A interface deve conter um botão de ação primária com o texto *"Verificar Conexão"* ou *"Iniciar Monitoramento"*.
  - **RF-04:** A tela deve apresentar um card informativo com visual limpo indicando que o sistema está pronto para monitorar a rede.

---

## 3. Implementação da Primeira Tela (Jetpack Compose)

### 📘 [GUIA DO TÓPICO]
> A primeira tela deve ser feita exclusivamente em **Jetpack Compose**, com espaçamentos, alinhamentos e tipografia bem estruturados (usando `Column`, `Text`, `Button`, `Spacer`, `Modifier.padding`, `MaterialTheme`).

### 💡 [SUGESTÃO DE TEXTO / ESTRUTURA DO CÓDIGO]:
- **Arquivo principal:** `projects/team-03/app/app/src/main/java/com/teamxx/teste/MainActivity.kt` (ou Composable `ui/screens/WelcomeScreen.kt`).
- **Componentes Utilizados:**
  - `Scaffold`: Estrutura base da tela com suporte a padding seguro de bordas (*edge-to-edge*).
  - `Column`: Organização vertical dos elementos centralizados na tela (`Alignment.CenterHorizontally`).
  - `Icon / Image`: Ícone visual de Wi-Fi (`Icons.Default.Wifi` ou drawable correspondente).
  - `Text`: Título em estilo `headlineMedium` e subtítulo em `bodyLarge`.
  - `Button`: Botão primário estilizado para chamar a ação principal.
  - `Spacer`: Espaçamentos verticais de `16.dp` e `32.dp` para garantir harmonia visual.

---

## 4. Validação e Evidência

### 📘 [GUIA DO TÓPICO]
> O professor exige que a imagem da primeira tela rodando no emulador ou celular seja salva na pasta de evidências e referenciada aqui.

- **Caminho da Evidência:** `evidence/sprint-01/first-screen.png`
- **Visualização:**

![Primeira Tela do WifiPulse](evidence/sprint-01/first-screen.png)

---

## 5. Critérios de Aceitação da Sprint 01

Marque com `[x]` os critérios validados:

- [ ] **AC-01** — Nome do produto, problema real, público-alvo e objetivo documentados.
- [ ] **AC-02** — Arquivo `SPEC-001.md` criado na pasta `docs/specs/`.
- [ ] **AC-03** — A especificação contém requisitos funcionais e critérios mensuráveis.
- [ ] **AC-04** — A primeira tela foi desenvolvida integralmente com Jetpack Compose.
- [ ] **AC-05** — O nome do aplicativo está claramente visível na tela.
- [ ] **AC-06** — O slogan explicativo está legível e bem posicionado.
- [ ] **AC-07** — O botão de ação primária está presente e visualmente destacado.
- [ ] **AC-08** — O projeto compila com sucesso (`BUILD SUCCESSFUL`).
- [ ] **AC-09** — O aplicativo executa sem falhas ou fechamentos inesperados (*no crash*).
- [ ] **AC-10** — A tela construída reflete fielmente o que foi especificado na SPEC-001.
- [ ] **AC-11** — Ambas as integrantes da equipe conseguem explicar o código e os componentes utilizados.

---

## 6. Registro de Uso de Inteligência Artificial (LLM)

### 📘 [GUIA DO TÓPICO]
> Preenchimento obrigatório para auditoria conforme a política da disciplina. O aluno deve sempre entender e validar as sugestões da IA.

| Item | Resposta da Equipe |
| :--- | :--- |
| **Ferramenta de IA utilizada** | [Ex: Claude 3.7 / ChatGPT-4o / Gemini] |
| **Tarefa apoiada pela IA** | Auxílio na elaboração da declaração do problema centrado no usuário e estrutura de alinhamento com `Column` e `Modifier` no Compose. |
| **Principal sugestão recebida** | Sugestão de utilizar `Arrangement.Center` com `Modifier.fillMaxSize()` e paleta de cores primárias do MaterialTheme para destacar o botão. |
| **O que a equipe alterou manualmente** | Adequação dos textos em português para o contexto do WifiPulse, ajuste de espaçamentos com `Spacer` e teste no emulador. |
| **Como o resultado foi validado** | Compilação no Android Studio e inspeção visual da tela executada no emulador Pixel com API 34. |

---

## 7. Informações de Submissão Git

- **Branch da Sprint:** `team-03/sprint-01`
- **Mensagens de Commits Recomendadas:**
  - `docs: define SPEC-001 and product goals for WifiPulse`
  - `feat: implement welcome screen using Jetpack Compose`
  - `docs: add sprint 01 report and visual evidence`
- **Título do Pull Request:** `[Sprint 01] Team 03 — Product Definition & First Screen`
