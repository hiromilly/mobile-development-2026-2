# SPRINT 03 — Navigation & Multiple Screens

**Deadline:** 05/10/2026  
**Purpose:** evolve the app from a single-screen prototype into a multi-screen Android application.

## Learning Goals

- screen responsibilities;
- Navigation Compose;
- routes and destinations;
- `NavHost` and `NavController`;
- forward/back navigation;
- separation of UI into Composables.

## Required Structure

```text
projects/team-XX/
├── app/
├── SPRINT-03.md
├── docs/specs/SPEC-003.md
└── evidence/sprint-03/
    ├── screen-a.png
    └── screen-b.png
```

## Step-by-Step

### 1. Create `team-XX/sprint-03`

Synchronize `main` first.

### 2. Define a Real Navigation Need

Identify at least two meaningful product screens, such as `Welcome → Home`, `List → Details`, or `Dashboard → Form`.

### 3. Write SPEC-003

Describe source screen, user action, destination, essential destination content, expected back behavior, and ACs.

### 4. Separate Screens

Create separate Composable functions/files where appropriate. Avoid keeping the entire UI inside one giant `MainActivity.kt`.

### 5. Add Navigation Compose

Implement a navigation controller, navigation host, at least two destinations, and one user action that navigates between them.

### 6. Validate the Flow

```text
Launch → initial screen → action → destination → back → previous screen
```

Also verify that Sprint 02 behavior still works.

### 7. Add Evidence

Save at least two screen captures in `evidence/sprint-03/`.

### 8. Complete the Sprint Report

Explain why each screen exists, what route connects them, where navigation is triggered, and how back navigation was validated.

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

Ask the LLM to explain `NavController`, `NavHost`, route design, back stack, or to review a small navigation graph. Use real error messages when requesting debugging help.

## Acceptance Criteria

- AC-01 — SPEC-003 exists.
- AC-02 — At least two meaningful screens exist.
- AC-03 — Navigation Compose is used.
- AC-04 — User action navigates between destinations.
- AC-05 — Destination content is visible.
- AC-06 — Back navigation behaves correctly.
- AC-07 — Previous Sprint functionality remains operational.
- AC-08 — App builds/runs without crashing.
- AC-09 — Navigation evidence exists.
- AC-10 — Team can explain the navigation graph.

## Deliverables

```text
projects/team-XX/app/
projects/team-XX/SPRINT-03.md
projects/team-XX/docs/specs/SPEC-003.md
projects/team-XX/evidence/sprint-03/screen-a.png
projects/team-XX/evidence/sprint-03/screen-b.png
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
team-XX/sprint-03
```

Example for Team 03:

```text
team-03/sprint-03
```

### Commits

Use small, meaningful commits. Recommended pattern:

```text
docs: define SPEC-003
feat: implement <feature>
fix: correct <problem>
docs: add Sprint 03 validation evidence
```

Avoid messages such as `update`, `changes`, `final`, `work`, or `commit 1`.

### Pull Request

Push/publish the Sprint branch to the team's fork and open **one Pull Request** to the course repository.

```text
base repository: brenofeliix/mobile-development-2026-2
base branch: main
compare branch: team-XX/sprint-03
```

PR title:

```text
[Sprint 03] Team XX — Navigation & Multiple Screens
```

PR description:

```md
## Sprint
SPRINT 03 — Navigation & Multiple Screens

## Summary
Briefly describe what was implemented.

## Specification
Link SPEC-003.

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

- [ ] SPEC-003 complete.
- [ ] At least two screens exist.
- [ ] Navigation and back behavior work.
- [ ] Previous functionality preserved.
- [ ] Evidence and AI usage documented.
- [ ] PR submitted.
