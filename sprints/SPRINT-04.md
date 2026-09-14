# SPRINT 04 — User Input, Forms & Validation

**Deadline:** 19/10/2026  
**Purpose:** collect data from the user safely and provide clear validation feedback.

## Learning Goals

- controlled input in Compose;
- form state;
- validation rules;
- error messages;
- valid/invalid flows.

## Required Structure

```text
projects/team-XX/
├── app/
├── SPRINT-04.md
├── docs/specs/SPEC-004.md
└── evidence/sprint-04/
    ├── valid-input.png
    └── invalid-input.png
```

## Step-by-Step

### 1. Create `team-XX/sprint-04`

Synchronize `main` first.

### 2. Choose Meaningful User Input

Examples: create task, register place, search term, quantity, note, profile field, or product preference.

### 3. Write SPEC-004

Define fields, required/optional status, allowed formats/values, validation rules, error feedback, and successful behavior.

### 4. Implement the Form

Use appropriate components such as `TextField`, `OutlinedTextField`, `Button`, `Checkbox`, `Switch`, `RadioButton`, or `DropdownMenu`. Use only what the feature needs.

### 5. Implement Validation

At minimum demonstrate one valid and one invalid scenario. Invalid input must produce visible feedback.

### 6. Test Both Scenarios

Verify rules, feedback, successful input, navigation, and previous features.

### 7. Add Evidence

Save `valid-input.png` and `invalid-input.png`.

### 8. Complete the Sprint Report

Explain each field, each validation rule, where each rule is implemented, and how both scenarios were tested.

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

Ask the LLM to review validation rules, generate boundary cases from SPEC-004, explain form state, review a small input component, or suggest clearer user-facing error messages without changing the business rule.

## Acceptance Criteria

- AC-01 — SPEC-004 exists.
- AC-02 — Meaningful user-input flow exists.
- AC-03 — Input values use UI state.
- AC-04 — At least one validation rule is implemented.
- AC-05 — Invalid input produces visible feedback.
- AC-06 — Valid input is accepted according to the SPEC.
- AC-07 — Valid and invalid evidence exists.
- AC-08 — Previous functionality still works.
- AC-09 — App builds/runs successfully.
- AC-10 — Team can explain validation logic.

## Deliverables

```text
projects/team-XX/app/
projects/team-XX/SPRINT-04.md
projects/team-XX/docs/specs/SPEC-004.md
projects/team-XX/evidence/sprint-04/valid-input.png
projects/team-XX/evidence/sprint-04/invalid-input.png
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
team-XX/sprint-04
```

Example for Team 03:

```text
team-03/sprint-04
```

### Commits

Use small, meaningful commits. Recommended pattern:

```text
docs: define SPEC-004
feat: implement <feature>
fix: correct <problem>
docs: add Sprint 04 validation evidence
```

Avoid messages such as `update`, `changes`, `final`, `work`, or `commit 1`.

### Pull Request

Push/publish the Sprint branch to the team's fork and open **one Pull Request** to the course repository.

```text
base repository: brenofeliix/mobile-development-2026-2
base branch: main
compare branch: team-XX/sprint-04
```

PR title:

```text
[Sprint 04] Team XX — User Input, Forms & Validation
```

PR description:

```md
## Sprint
SPRINT 04 — User Input, Forms & Validation

## Summary
Briefly describe what was implemented.

## Specification
Link SPEC-004.

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

- [ ] SPEC-004 complete.
- [ ] Form/input flow implemented.
- [ ] Validation implemented.
- [ ] Valid/invalid scenarios tested.
- [ ] Evidence and AI usage documented.
- [ ] PR submitted.
