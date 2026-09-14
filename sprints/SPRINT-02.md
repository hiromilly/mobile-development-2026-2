# SPRINT 02 — State & User Interaction

**Deadline:** 28/09/2026  
**Work session:** 26/09/2026  
**Purpose:** make the interface react to user actions and introduce UI state in Jetpack Compose.

## Learning Goals

- state in declarative UI;
- events and event handlers;
- `remember` and `mutableStateOf`;
- state-driven rendering;
- user feedback.

## Required Structure

```text
projects/team-XX/
├── app/
├── SPRINT-02.md
├── docs/specs/SPEC-002.md
└── evidence/sprint-02/
    ├── before-interaction.png
    └── after-interaction.png
```

## Step-by-Step

### 1. Synchronize and Create the Branch

Confirm Sprint 01 was merged, synchronize the fork's `main`, then create `team-XX/sprint-02`.

### 2. Choose One Meaningful Interaction

Examples: select an option, toggle favorite, show/hide information, increment a quantity, change a filter, or update a visible message. It must make sense for the product.

### 3. Write SPEC-002

Define initial state, user action, expected state change, visible result, constraints, and acceptance criteria.

### 4. Implement State

Use a state value appropriate to the feature. A simple Boolean pattern may look like:

```kotlin
var selected by remember { mutableStateOf(false) }
```

The team must understand what each part does and use a different state type when appropriate.

### 5. Connect Event → State → UI

Validate the chain:

```text
Initial state → user action → updated state → visible UI response
```

### 6. Validate Regression

Confirm Sprint 01 still works and the new interaction is repeatable without crashes.

### 7. Add Evidence

Save before/after screenshots in `evidence/sprint-02/`.

### 8. Complete the Sprint Report

Explain what state was introduced, what event changes it, which UI reacts, and which FR/AC were validated.

## Rules for Using an LLM

LLM-assisted tools are allowed in this Sprint, but the team remains responsible for every submitted line of code and documentation.

Use an LLM to **support** the development process, not to replace it. Recommended workflow:

1. provide the current SPEC and only the smallest relevant code excerpt;
2. describe the exact problem or change;
3. ask for an explanation before accepting code;
4. request the minimum change needed;
5. review the suggestion manually;
6. run the app and validate the acceptance criteria;
7. keep only code the team can explain and modify without the LLM.

Generic prompt:

```text
We are developing an Android application with Kotlin and Jetpack Compose.
Current Sprint: SPRINT-YY.
Current requirement: [paste the relevant FR/AC from the SPEC].
Current code/context: [paste only the relevant excerpt].

Help us implement or review this requirement.
1. Explain the concept first.
2. Propose the smallest change that satisfies the requirement.
3. Explain every relevant part of the suggested code.
4. Identify possible errors or edge cases.
5. Tell us how to validate the result in Android Studio.
Do not add functionality outside the current Sprint scope.
```

Complete this table in the Sprint report:

| Item | Team response |
| --- | --- |
| LLM/tool used |  |
| Task supported by the LLM |  |
| Main suggestion received |  |
| What the team changed manually |  |
| How the result was validated |  |

Do not submit code that no team member can explain. During review, any member may be asked to locate a requirement in the code, explain a function, justify a decision, or make a small modification.

### Suggested LLM Uses

Ask the LLM to explain state versus a normal variable, `remember`, `mutableStateOf`, why UI is not updating, or to generate test scenarios from SPEC-002.

## Acceptance Criteria

- AC-01 — SPEC-002 exists.
- AC-02 — Meaningful interaction is defined.
- AC-03 — App contains at least one state value.
- AC-04 — User event changes the state.
- AC-05 — Visible UI reacts to state change.
- AC-06 — Initial and updated states behave correctly.
- AC-07 — Previous functionality still works.
- AC-08 — App builds/runs without crashing.
- AC-09 — Before/after evidence exists.
- AC-10 — Team can explain the state flow.

## Deliverables

```text
projects/team-XX/app/
projects/team-XX/SPRINT-02.md
projects/team-XX/docs/specs/SPEC-002.md
projects/team-XX/evidence/sprint-02/before-interaction.png
projects/team-XX/evidence/sprint-02/after-interaction.png
```

## Submission Rules

### Repository Location

All work must remain inside:

```text
projects/team-XX/
```

Never modify another team's folder.

### Branch

Synchronize the fork with the current course `main`, then create the branch **before** starting the Sprint work:

```text
team-XX/sprint-02
```

Example for Team 03:

```text
team-03/sprint-02
```

### Commits

Use small, meaningful commits. Recommended pattern:

```text
docs: define SPEC-002
feat: implement <feature>
fix: correct <problem>
docs: add Sprint 02 validation evidence
```

Avoid messages such as `update`, `changes`, `final`, `work`, or `commit 1`.

### Pull Request

Push/publish the Sprint branch to the team's fork and open **one Pull Request** to the course repository.

```text
base repository: brenofeliix/mobile-development-2026-2
base branch: main
compare branch: team-XX/sprint-02
```

PR title:

```text
[Sprint 02] Team XX — State & User Interaction
```

PR description:

```md
## Sprint
SPRINT 02 — State & User Interaction

## Summary
Briefly describe what was implemented.

## Specification
Link SPEC-002.

## Validation
- [ ] Application builds successfully.
- [ ] Application runs successfully.
- [ ] Acceptance criteria were validated.
- [ ] Evidence was added.
- [ ] Team members can explain the implementation.

## AI Usage
Briefly summarize how an LLM was used and how its suggestions were validated.
```

Students **must not merge their own PR** into the course repository. The instructor reviews and merges accepted submissions.

If changes are requested, continue on the **same branch**. Commit and push the corrections; the existing PR updates automatically. Do not open a second PR for the same Sprint unless the instructor explicitly requests it.

## Definition of Done

- [ ] SPEC-002 complete.
- [ ] State/interaction implemented.
- [ ] UI responds visibly.
- [ ] Previous functionality preserved.
- [ ] Evidence and AI usage documented.
- [ ] PR submitted.
