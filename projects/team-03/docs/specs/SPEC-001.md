# SPEC-001 — Definição do Produto WifiPulse e Primeira Tela

> **Equipe:** Team 03  
> **Integrantes:** Célia Hiromi (@hiromilly) e Geovanna Gaspar (@gegwspar)  
> **Sprint:** SPRINT 01  
> **Status:** Em Andamento  

---

## 1. Contexto

Pessoas que trabalham ou estudam em regime domiciliar dependem diariamente da estabilidade da rede Wi-Fi. No entanto, instabilidades e variações na qualidade do sinal causam interrupções em chamadas de vídeo, downloads e navegação em geral. A maioria dos usuários não sabe se o problema é a distância do roteador, interferências físicas ou falha na operadora. Os aplicativos existentes de análise de rede no mercado são técnicos em excesso, cheios de gráficos poluídos e anúncios intrusivos. O **WifiPulse** surge para entregar uma experiência limpa, direta e amigável para monitoramento e diagnóstico de conexões Wi-Fi.

---

## 2. Tarefa

Definir formalmente o produto **WifiPulse** e implementar a primeira tela da aplicação utilizando **Kotlin** e **Jetpack Compose**, contendo identidade visual clara, nome da aplicação, slogan explicativo e um botão de ação primária que inicia a jornada do usuário.

---

## 3. Requisitos Funcionais

- **RF-01 — Identidade do Produto:** A tela deve exibir o nome do aplicativo (**WifiPulse**) com tipografia de destaque (`headlineMedium` ou `headlineLarge`) e um ícone temático de sinal Wi-Fi.
- **RF-02 — Proposta de Valor:** A tela deve conter uma frase descritiva (slogan) informando o objetivo do app de forma acessível ao usuário comum.
- **RF-03 — Ação Primária:** A tela deve apresentar um botão de destaque visual com o texto *"Iniciar Monitoramento"* ou *"Verificar Conexão"*.
- **RF-04 — Organização Visual:** Os elementos da interface devem estar centralizados, com espaçamentos proporcionais e suporte ao tema do sistema (Material Design 3).

---

## 4. Restrições Técnicas

- **Linguagem:** Kotlin.
- **UI Framework:** Jetpack Compose (sem uso de layouts legados em XML).
- **Design System:** Material Theme 3 (`MaterialTheme.colorScheme`).
- **Versão Mínima do Android:** Android API 24 (Android 7.0) ou superior.
- **Arquitetura:** Componente desacoplado `WelcomeScreen` preparado para receber navegação futura na Sprint 03.

---

## 5. Critérios de Aceitação

- **CA-01:** Ao abrir o aplicativo, o nome **WifiPulse** deve estar visível e centralizado no topo do card principal.
- **CA-02:** O slogan ou descrição da proposta de valor deve estar claramente legível abaixo do nome.
- **CA-03:** O botão de ação primária deve ser clicável e apresentar efeito de clique (ripple).
- **CA-04:** A tela deve se adaptar adequadamente em emuladores e aparelhos físicos de diferentes densidades sem truncar textos.
- **CA-05:** O projeto deve compilar sem warnings críticos ou erros de layout.

---

## 6. Procedimento de Validação

1. Executar `./gradlew assembleDebug` para confirmar a compilação bem-sucedida.
2. Abrir o aplicativo no emulador Android ou celular físico.
3. Verificar a presença dos componentes: Nome, Slogan, Ícone e Botão.
4. Tocar no botão primário para testar a responsividade e o feedback tátil/visual.
5. Capturar a tela e salvar o arquivo em: `projects/team-03/evidence/sprint-01/first-screen.png`.

---

## 7. Registro de Uso de Inteligência Artificial (LLM)

### Ferramenta
- Claude 3.7 / Gemini / ChatGPT

### Finalidade
- Auxílio na estruturação da declaração do problema centrado na necessidade do usuário e validação dos critérios de aceitação.

### Conteúdo Gerado
- Sugestão de requisitos funcionais e texto da proposta de valor.

### Revisão e Alterações Humanas
- Adaptação das frases para o tom de voz do produto em português e definição das restrições técnicas específicas do projeto.

---

## 8. Fora do Escopo (Out of Scope)

- Leitura de permissões perigosas do sistema Android (planejado para a Sprint 06).
- Medição de taxa de download/upload e testes de ping avançados (planejado para sprints futuras).
- Armazenamento em banco de dados local (planejado para a Sprint 05).
- Navegação entre múltiplas telas (planejado para a Sprint 03).

---

## 9. Entregáveis

- `projects/team-03/app/` (Código fonte em Compose)
- `projects/team-03/SPRINT-01.md` (Relatório da Sprint 01)
- `projects/team-03/docs/specs/SPEC-001.md` (Esta especificação técnica)
- `projects/team-03/evidence/sprint-01/first-screen.png` (Evidência visual)

---

## 10. Status

- [x] Especificação técnica elaborada
- [ ] Implementação de código da tela finalizada
- [ ] Critérios de aceitação validados no emulador/aparelho
- [ ] Captura de evidência anexada
- [ ] Commit semântico realizado
- [ ] Pull Request da Sprint 01 aberto
