# SPRINT 07 — Final Integration, Quality & Delivery

**FINAL DEADLINE:** 23/11/2026  
**Purpose:** integrate the accumulated product, remove critical defects, validate the complete application, and produce the final delivery.

This is the final regular Sprint submission.

## Learning Goals

- complete-product validation;
- regression testing;
- defect correction;
- usability/consistency review;
- known limitations;
- traceability from requirements to code/evidence;
- reproducible final delivery.

## Required Final Structure

```text
projects/team-XX/
├── app/
├── README.md
├── SPRINT-07.md
├── docs/specs/
│   ├── SPEC-001.md
│   ├── SPEC-002.md
│   ├── SPEC-003.md
│   ├── SPEC-004.md
│   ├── SPEC-005.md
│   ├── SPEC-006.md
│   └── SPEC-007.md
└── evidence/sprint-07/
    ├── final-home.png
    ├── final-feature.png
    └── final-validation.md
```

## Step-by-Step

### 1. Create `team-XX/sprint-07`

Synchronize with the latest accepted `main` first.

### 2. Create SPEC-007: Final Quality Specification

SPEC-007 is **not** a request for a new major feature. Define final requirements for launch flow, navigation, input validation, persistence, integration states, crash-free tested flow, visual consistency, feedback, and final acceptance scenarios.

### 3. Review All Previous SPECs

Add this table to `SPRINT-07.md`:

| Specification | Main feature | Current status | Evidence |
| --- | --- | --- | --- |
| SPEC-001 |  | PASS/FAIL |  |
| SPEC-002 |  | PASS/FAIL |  |
| SPEC-003 |  | PASS/FAIL |  |
| SPEC-004 |  | PASS/FAIL |  |
| SPEC-005 |  | PASS/FAIL |  |
| SPEC-006 |  | PASS/FAIL |  |
| SPEC-007 | Final quality | PASS/FAIL |  |

A discovered FAIL must be fixed or explicitly documented as a known limitation.

### 4. Run Regression Testing

From a clean launch, validate:

```text
1. Application launches.
2. Main screen is usable.
3. Navigation works.
4. State/interaction feature works.
5. Form/input validation works.
6. Persistent data works.
7. External/device integration works or fails gracefully.
8. Back navigation behaves correctly.
9. No critical crash occurs in the tested journey.
```

### 5. Improve Usability and Consistency

Review spacing, alignment, labels, readability, terminology, empty states, loading/error feedback, duplicated UI, and obvious accessibility problems. Do not redesign the entire app at the last minute.

### 6. Clean the Repository

Do not submit `.idea/`, `.gradle/`, `build/`, `local.properties`, API keys, passwords, tokens, or unrelated large files. Keep required source/configuration files and the Gradle wrapper.

### 7. Complete the Team README

`projects/team-XX/README.md` must include product name, problem, target users, main features, technologies, how to build/run, required configuration, known limitations, and team members.

### 8. Add Final Evidence

Create `final-home.png`, `final-feature.png`, and `final-validation.md`. The validation file must state the test device and executed scenarios.

### 9. Prepare the Final Demonstration

Every member must be able to demonstrate and explain at least one part of the app through:

```text
Problem → Product goal → SPEC → Implementation → Validation → Evidence
```

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

Ask the LLM to generate regression scenarios from the existing SPECs, find missing evidence, review README clarity, identify low-risk refactoring opportunities, or help explain a defect before fixing it.

### Final LLM Restrictions

Do not use an LLM to fabricate screenshots, test results, execution evidence, device information, completed acceptance criteria, or unimplemented features. Evidence must come from real execution.

## Final Acceptance Criteria

- AC-01 — SPEC-007 exists.
- AC-02 — All previous specifications were reviewed.
- AC-03 — Core product flow works from launch.
- AC-04 — Navigation works.
- AC-05 — State/interaction feature works.
- AC-06 — Form validation works.
- AC-07 — Persistence works according to SPEC-005.
- AC-08 — Integration works or fails gracefully according to SPEC-006.
- AC-09 — No known critical crash occurs in the documented test flow.
- AC-10 — Final evidence is complete.
- AC-11 — Team README is complete.
- AC-12 — No secrets/generated build folders are submitted.
- AC-13 — Key requirements can be traced to code and evidence.
- AC-14 — Every member can explain the project.

## Final Deliverables

```text
projects/team-XX/app/
projects/team-XX/README.md
projects/team-XX/SPRINT-07.md
projects/team-XX/docs/specs/SPEC-001.md ... SPEC-007.md
projects/team-XX/evidence/sprint-07/final-home.png
projects/team-XX/evidence/sprint-07/final-feature.png
projects/team-XX/evidence/sprint-07/final-validation.md
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
team-XX/sprint-07
```

Example for Team 03:

```text
team-03/sprint-07
```

### Commits

Use small, meaningful commits. Recommended pattern:

```text
docs: define SPEC-007
feat: implement <feature>
fix: correct <problem>
docs: add Sprint 07 validation evidence
```

Avoid messages such as `update`, `changes`, `final`, `work`, or `commit 1`.

### Pull Request

Push/publish the Sprint branch to the team's fork and open **one Pull Request** to the course repository.

```text
base repository: brenofeliix/mobile-development-2026-2
base branch: main
compare branch: team-XX/sprint-07
```

PR title:

```text
[Sprint 07] Team XX — Final Integration, Quality & Delivery
```

PR description:

```md
## Sprint
SPRINT 07 — Final Integration, Quality & Delivery

## Summary
Briefly describe what was implemented.

## Specification
Link SPEC-007.

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

## Final Definition of Done

- [ ] SPEC-007 complete.
- [ ] Regression testing executed.
- [ ] Critical issues fixed or documented.
- [ ] README complete.
- [ ] Final evidence real and complete.
- [ ] Repository clean.
- [ ] AI usage documented.
- [ ] Final PR submitted no later than 23/11/2026.
