# SPRINT 05 — Local Persistence & Data

**Deadline:** 09/11/2026  
**Purpose:** make useful application data survive beyond temporary screen state.

## Learning Goals

- transient state vs persistent data;
- local storage choices;
- basic data models;
- saving and reading data;
- restart validation;
- separation between UI and data responsibilities.

## Persistence Choice

Use **Room** for structured records (tasks, notes, favorites, places, registrations, history). Use **DataStore** for small preference-like values (theme, onboarding flag, simple settings). The instructor may require Room when the product clearly needs structured records.

## Required Structure

```text
projects/team-XX/
├── app/
├── SPRINT-05.md
├── docs/specs/SPEC-005.md
└── evidence/sprint-05/
    ├── data-created.png
    └── data-restored.png
```

## Step-by-Step

### 1. Create `team-XX/sprint-05`

Synchronize `main` first.

### 2. Identify What Must Persist

Answer: what is stored, why it must persist, when it is written, when it is read, and how the user observes it.

### 3. Write SPEC-005

Define data fields, create/update behavior, read behavior, persistence expectation, visible result, and ACs.

### 4. Define the Data Model

For Room, define the minimum entity/data structure and access operations. For DataStore, define only the necessary preference values. Do not invent fields not required by the SPEC.

### 5. Implement Save and Read

Examples:

```text
Create item → restart → item still exists
Favorite place → restart → favorite remains
Change setting → reopen → setting remains
```

### 6. Organize Data Logic

Avoid placing all persistence code directly inside a button's `onClick`. Keep UI code understandable.

### 7. Validate Persistence

Create/change data, confirm it, restart the app, reopen it, and confirm the expected data remains.

### 8. Add Evidence

Save `data-created.png` and `data-restored.png`.

### 9. Complete the Sprint Report

Explain selected persistence mechanism, reason, data model, save flow, read flow, and restart result.

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

Ask the LLM to compare Room vs DataStore for the team's real requirement, explain Entity/DAO/Database concepts, review a small data model, identify persistence edge cases, or interpret a real Room/KSP/Gradle error.

## Acceptance Criteria

- AC-01 — SPEC-005 exists.
- AC-02 — Appropriate persistence mechanism selected.
- AC-03 — Required persistent data is modeled.
- AC-04 — Data can be saved/changed.
- AC-05 — Data can be read and displayed/used.
- AC-06 — Expected data survives app restart.
- AC-07 — Previous functionality remains operational.
- AC-08 — App builds successfully.
- AC-09 — Persistence evidence exists.
- AC-10 — Team can explain the data flow.

## Deliverables

```text
projects/team-XX/app/
projects/team-XX/SPRINT-05.md
projects/team-XX/docs/specs/SPEC-005.md
projects/team-XX/evidence/sprint-05/data-created.png
projects/team-XX/evidence/sprint-05/data-restored.png
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
team-XX/sprint-05
```

Example for Team 03:

```text
team-03/sprint-05
```

### Commits

Use small, meaningful commits. Recommended pattern:

```text
docs: define SPEC-005
feat: implement <feature>
fix: correct <problem>
docs: add Sprint 05 validation evidence
```

Avoid messages such as `update`, `changes`, `final`, `work`, or `commit 1`.

### Pull Request

Push/publish the Sprint branch to the team's fork and open **one Pull Request** to the course repository.

```text
base repository: brenofeliix/mobile-development-2026-2
base branch: main
compare branch: team-XX/sprint-05
```

PR title:

```text
[Sprint 05] Team XX — Local Persistence & Data
```

PR description:

```md
## Sprint
SPRINT 05 — Local Persistence & Data

## Summary
Briefly describe what was implemented.

## Specification
Link SPEC-005.

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

- [ ] SPEC-005 complete.
- [ ] Persistence implemented.
- [ ] Save/read/restart validated.
- [ ] Previous functionality preserved.
- [ ] Evidence and AI usage documented.
- [ ] PR submitted.
