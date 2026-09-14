# SPEC-XXX — Feature Name

> **Team:** Team XX  
> **Sprint:** Sprint YY  
> **Status:** Draft / In Progress / Validated  
> **Related Sprint:** `SPRINT-YY.md`

<!--
HOW TO USE THIS TEMPLATE

1. Replace SPEC-XXX with the next specification number.
2. Replace "Feature Name" with a short, clear name.
3. Remove all instructional comments before the final submission.
4. Keep requirement IDs (FR-XX) and acceptance criteria IDs (AC-XX).
5. Every requirement should be testable.
6. Do not describe features that are outside the current Sprint.
-->

---

## 1. Context

<!--
Explain WHY this feature is needed.

Answer:
- What problem does it solve?
- Who will use it?
- In what situation will it be used?

Avoid describing implementation details here.
-->

**Problem:**

[Describe the problem.]

**User / Actor:**

[Who needs this feature?]

**Usage Context:**

[When or why will this feature be used?]

---

## 2. Objective

<!--
Describe the expected outcome in 1–3 sentences.

Use language such as:
"The objective of this feature is to..."
-->

The objective of this feature is to [describe the expected result].

---

## 3. User Scenario

<!--
Describe one simple scenario from the user's perspective.

Recommended format:
Given...
When...
Then...
-->

**Given** [initial situation],  
**When** [user action],  
**Then** [expected result].

---

## 4. Functional Requirements

<!--
Functional Requirements describe WHAT the application must do.

Rules:
- Use one requirement per item.
- Use observable language.
- Avoid vague words such as "good", "beautiful", "easy", or "fast"
  unless they are made measurable.
-->

### FR-01 — [Short requirement name]

The application must [describe the required behavior].

### FR-02 — [Short requirement name]

The application must [describe the required behavior].

### FR-03 — [Short requirement name]

The application must [describe the required behavior].

<!-- Add or remove FR items as necessary. -->

---

## 5. Constraints

<!--
Constraints define technical or project boundaries.

Include only constraints that are relevant to this feature.
-->

### Required Technologies

- Kotlin
- Jetpack Compose
- Android Studio

### Project Constraints

- [Example: Minimum SDK must remain API 24.]
- [Example: The feature must be implemented inside the existing Android project.]
- [Example: No external API may be used in this Sprint.]
- [Example: No new library may be added without justification.]

### Files or Modules That Must Not Be Modified

- [If applicable, list them here.]
- [Write "None" if there are no restrictions.]

---

## 6. Out of Scope

<!--
Explicitly list what must NOT be implemented in this specification.

This section prevents teams and AI tools from implementing unnecessary
features outside the current Sprint.
-->

The following items are outside the scope of this specification:

- [Out-of-scope item 1]
- [Out-of-scope item 2]
- [Out-of-scope item 3]

---

## 7. Acceptance Criteria

<!--
Acceptance Criteria define HOW the team will know that each requirement
was correctly implemented.

Every criterion must describe something observable or verifiable.
Whenever possible, map each AC to one or more FRs.
-->

### AC-01 — [Criterion name]

**Related requirement:** FR-01

**Condition:**  
[Describe the observable condition that must be true.]

### AC-02 — [Criterion name]

**Related requirement:** FR-02

**Condition:**  
[Describe the observable condition that must be true.]

### AC-03 — [Criterion name]

**Related requirement:** FR-03

**Condition:**  
[Describe the observable condition that must be true.]

<!-- Add or remove AC items as necessary. -->

---

## 8. Requirement Traceability

<!--
This table connects requirements, implementation, validation, and evidence.

Complete it after implementation.
-->

| Requirement | Implemented In | Acceptance Criterion | Evidence |
| --- | --- | --- | --- |
| FR-01 | `[file / function / composable]` | AC-01 | `[evidence file]` |
| FR-02 | `[file / function / composable]` | AC-02 | `[evidence file]` |
| FR-03 | `[file / function / composable]` | AC-03 | `[evidence file]` |

---

## 9. Implementation Plan

<!--
Before coding, briefly describe the intended solution.

Do NOT paste generated code here.
Focus on the planned structure.
-->

### Components to Create or Modify

- [Composable / class / file / screen]
- [Composable / class / file / screen]

### Expected Interaction Flow

```text
[Initial state]
      ↓
[User action]
      ↓
[Application response]
      ↓
[Expected final state]
```

### Data or State Required

- [State variable / data structure / input]
- [Write "None" if no state is required.]

---

## 10. Validation Plan

<!--
Describe HOW the team will validate the feature before implementation
is considered complete.
-->

The team must:

1. Build the project successfully.
2. Run the application on an Android Emulator or physical Android device.
3. Execute the expected user scenario.
4. Verify every acceptance criterion.
5. Test at least one invalid, unexpected, or alternative input when applicable.
6. Collect the required evidence.

---

## 11. Validation Results

<!--
Complete this section AFTER testing the implementation.
Do not mark PASS before actually validating the criterion.
-->

| Acceptance Criterion | Result | Notes |
| --- | --- | --- |
| AC-01 | PASS / FAIL | [Brief validation note] |
| AC-02 | PASS / FAIL | [Brief validation note] |
| AC-03 | PASS / FAIL | [Brief validation note] |

### Environment Used for Validation

- **Device:** [Emulator model or physical device]
- **Android version / API:** [API XX]
- **Build result:** PASS / FAIL
- **Application execution:** PASS / FAIL

---

## 12. Evidence

<!--
Store evidence inside:
projects/team-XX/evidence/sprint-YY/

Use meaningful file names.
-->

Required evidence:

- `[evidence/sprint-YY/example-before.png]`
- `[evidence/sprint-YY/example-after.png]`

<!--
When useful, embed the image using a relative Markdown path:

![Evidence description](../../evidence/sprint-YY/example.png)

Adjust the relative path according to the location of this SPEC file.
-->

---

## 13. AI-Assisted Development

AI tools may be used, but the team remains responsible for the final solution.

### AI Tool(s)

- **Tool:** [ChatGPT / Gemini / Copilot / Claude / other]
- **Model/version, if known:** [optional]

### How AI Was Used

<!-- Check all that apply and explain briefly. -->

- [ ] Understanding the requirement
- [ ] Refining the specification
- [ ] Generating implementation suggestions
- [ ] Explaining code
- [ ] Debugging
- [ ] Refactoring
- [ ] Generating test ideas
- [ ] Reviewing acceptance criteria
- [ ] Other: [describe]

### Prompt or Request Summary

<!--
Do not need to paste a very long conversation.
Summarize the main request(s) sent to the AI.
-->

[Briefly describe what was asked.]

### AI-Generated or Suggested Content

[Describe what the AI suggested or generated.]

### Human Review and Changes

<!--
This section is mandatory when AI was used.

Explain:
- what was accepted;
- what was rejected;
- what was corrected;
- what was adapted;
- how the team verified the result.
-->

[Describe the team's review and modifications.]

### AI Validation

The team confirms that:

- [ ] AI-generated content was reviewed before being used.
- [ ] The team understands the submitted implementation.
- [ ] The implementation was built and executed.
- [ ] Acceptance criteria were validated manually.
- [ ] No feature outside the Sprint scope was added only because an AI tool suggested it.

---

## 14. Suggested Prompt for AI Assistance

<!--
Students may adapt this prompt to the current feature.
Do not send the entire repository if only a small part is necessary.
-->

```text
I am developing an Android application using Kotlin and Jetpack Compose.

Current Sprint:
[SPRINT]

Feature specification:
[PASTE THE RELEVANT PART OF THIS SPEC]

Current implementation:
[PASTE ONLY THE RELEVANT CODE OR DESCRIBE THE CURRENT STRUCTURE]

Task:
[DESCRIBE ONE SPECIFIC TASK]

Constraints:
[PASTE THE RELEVANT CONSTRAINTS]

Out of scope:
[PASTE THE OUT-OF-SCOPE ITEMS]

Please:
1. explain the proposed solution before providing code;
2. implement only what is necessary for this specification;
3. identify which functional requirement each change addresses;
4. explain unfamiliar Compose/Kotlin concepts;
5. describe how I can validate each acceptance criterion;
6. do not add features outside the current Sprint.
```

---

## 15. Deliverables

The following artifacts must be included in the team's Sprint submission:

- [ ] Updated Android application
- [ ] This completed specification
- [ ] Updated `SPRINT-YY.md`
- [ ] Required validation evidence
- [ ] Any additional artifact required by the Sprint instructions

---

## 16. Specification Status

<!--
This checklist refers only to the feature specification and its implementation.
Git branch, commit, and Pull Request rules are defined in the Sprint instructions.
-->

- [ ] Context and objective are clear.
- [ ] Functional requirements are complete.
- [ ] Constraints are documented.
- [ ] Out-of-scope items are documented.
- [ ] Acceptance criteria are measurable.
- [ ] Requirement traceability is complete.
- [ ] Implementation satisfies the specification.
- [ ] Validation results are documented.
- [ ] Evidence is included.
- [ ] AI usage is documented when applicable.
- [ ] Every team member can explain the implemented feature.

---

## Final Check

Before submitting the Sprint, the team should be able to answer:

> **Which requirement does this code implement, where is it implemented, and what evidence proves that the requirement was satisfied?**
