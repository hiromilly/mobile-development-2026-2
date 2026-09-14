# SPRINT 06 — External or Device Integration

**Deadline:** 16/11/2026  
**Purpose:** connect the application to one external data source or Android device capability that is meaningful to the product.

## Learning Goals

- integration boundaries;
- asynchronous operations;
- loading/success/error states;
- permissions when required;
- defensive handling of unavailable services.

## Choose One Approved Integration

Select one relevant integration: REST API, location, maps, camera/gallery, notifications, sensors, or another Android capability approved by the instructor.

## Required Structure

```text
projects/team-XX/
├── app/
├── SPRINT-06.md
├── docs/specs/SPEC-006.md
└── evidence/sprint-06/
    ├── integration-success.png
    └── integration-alternative-state.png
```

## Step-by-Step

### 1. Create `team-XX/sprint-06`

Synchronize `main` first.

### 2. Define the Integration Boundary

Document what capability/service is used, why the product needs it, what the app requests/sends, what it receives, and what can fail.

### 3. Write SPEC-006

Define trigger, loading state when applicable, successful result, failure/unavailable result, permission behavior when applicable, and ACs.

### 4. Implement the Smallest Useful Integration

For a REST API, one endpoint may be enough. For a device capability, one permission + one meaningful operation may be enough. Do not add unrelated endpoints/features.

### 5. Represent Integration States in the UI

Show relevant states such as loading, success, error/unavailable, or permission denied. At least one alternative/failure state must be handled explicitly.

### 6. Protect Secrets

Never commit API secrets, private tokens, passwords, or personal credentials. Ask the instructor before using a service that requires a secret.

### 7. Validate Two Scenarios

Test one success scenario and one error/denied/empty/unavailable/alternative scenario.

### 8. Add Evidence

Save the two required screenshots.

### 9. Complete the Sprint Report

Explain chosen integration, product relevance, data/capability flow, asynchronous behavior, failure handling, and privacy/security considerations.

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

Ask the LLM to explain coroutines/asynchronous execution at the level required, review a permission flow, explain an API response model, identify missing loading/error states, interpret actual HTTP/JSON/permission errors, or review code for accidentally hard-coded secrets.

## Acceptance Criteria

- AC-01 — SPEC-006 exists.
- AC-02 — Integration is relevant to product goal.
- AC-03 — App can trigger the integration.
- AC-04 — Successful result is observable.
- AC-05 — At least one alternative/error/denied/unavailable state is handled.
- AC-06 — No private secrets are committed.
- AC-07 — Previous functionality remains operational.
- AC-08 — App builds/runs successfully.
- AC-09 — Success and alternative-state evidence exists.
- AC-10 — Team can explain the integration flow.

## Deliverables

```text
projects/team-XX/app/
projects/team-XX/SPRINT-06.md
projects/team-XX/docs/specs/SPEC-006.md
projects/team-XX/evidence/sprint-06/integration-success.png
projects/team-XX/evidence/sprint-06/integration-alternative-state.png
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
team-XX/sprint-06
```

Example for Team 03:

```text
team-03/sprint-06
```

### Commits

Use small, meaningful commits. Recommended pattern:

```text
docs: define SPEC-006
feat: implement <feature>
fix: correct <problem>
docs: add Sprint 06 validation evidence
```

Avoid messages such as `update`, `changes`, `final`, `work`, or `commit 1`.

### Pull Request

Push/publish the Sprint branch to the team's fork and open **one Pull Request** to the course repository.

```text
base repository: brenofeliix/mobile-development-2026-2
base branch: main
compare branch: team-XX/sprint-06
```

PR title:

```text
[Sprint 06] Team XX — External or Device Integration
```

PR description:

```md
## Sprint
SPRINT 06 — External or Device Integration

## Summary
Briefly describe what was implemented.

## Specification
Link SPEC-006.

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

- [ ] SPEC-006 complete.
- [ ] One meaningful integration works.
- [ ] Success and alternative states handled.
- [ ] No secrets committed.
- [ ] Evidence and AI usage documented.
- [ ] PR submitted.
