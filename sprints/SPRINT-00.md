# SPRINT 00 — Development Environment & Git Workflow

**Suggested completion:** 24/08/2026  
**Purpose:** prepare the complete development and submission environment before product implementation begins.

## Learning Goals

By the end of this Sprint, the team should be able to:

- identify the role of Android Studio, Android SDK, Gradle, Git, GitHub, emulator, and physical device;
- create and run a basic Android application;
- work with a fork of the course repository;
- create a team branch;
- commit and push changes;
- open a Pull Request to the course repository.

## Expected Structure

```text
projects/team-XX/
├── app/
├── SPRINT-00.md
└── evidence/
    └── sprint-00/
        └── android-running.png
```

## Step-by-Step

### 1. Fork the Course Repository

1. Sign in to GitHub.
2. Open `brenofeliix/mobile-development-2026-2`.
3. Create a fork in the account of the team's Submission Lead.
4. Do not rename the fork.

### 2. Clone the Team Fork

1. Install and sign in to GitHub Desktop.
2. Configure the student's real name and e-mail for commits.
3. Clone the **student fork**, not the professor's repository.
4. Prefer a local path outside OneDrive.
5. If asked how the fork will be used, choose `To contribute to the parent project`.

### 3. Create the Sprint Branch

Before editing any file, create:

```text
team-XX/sprint-00
```

### 4. Prepare Android Studio

Use the stable Android Studio release. Confirm that the SDK includes Android SDK Platform, Build-Tools, Platform-Tools, Command-line Tools (latest), and Android Emulator when supported.

### 5. Prepare a Device

Use either:

- Android Emulator; or
- physical Android device with USB debugging enabled.

Both are valid for this course.

### 6. Create the Android Project

Create the project directly inside:

```text
projects/team-XX/app/
```

Recommended configuration:

```text
Template: Empty Activity
Language: Kotlin
UI: Jetpack Compose
Minimum SDK: API 24 or compatible
Build configuration: Kotlin DSL
```

### 7. Build and Run

1. Select the emulator or physical device.
2. Run the application.
3. Confirm that the first screen appears without crashing.
4. Capture a screenshot.
5. Save it as `projects/team-XX/evidence/sprint-00/android-running.png`.

### 8. Complete SPRINT-00.md

Include team number, members, device used, Android Studio version, build/run result, and problems encountered with their solutions.

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

## Acceptance Criteria

- AC-01 — Team fork exists.
- AC-02 — Repository was cloned locally.
- AC-03 — Sprint branch was created.
- AC-04 — Android project exists under `projects/team-XX/app/`.
- AC-05 — Project builds successfully.
- AC-06 — App runs on emulator or physical device.
- AC-07 — Execution evidence exists.
- AC-08 — Team can explain fork, clone, branch, commit, push, and Pull Request.

## Deliverables

```text
projects/team-XX/app/
projects/team-XX/SPRINT-00.md
projects/team-XX/evidence/sprint-00/android-running.png
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
team-XX/sprint-00
```

Example for Team 03:

```text
team-03/sprint-00
```

### Commits

Use small, meaningful commits. Recommended pattern:

```text
docs: define N/A — Sprint 00 has no feature SPEC
feat: implement <feature>
fix: correct <problem>
docs: add Sprint 00 validation evidence
```

Avoid messages such as `update`, `changes`, `final`, `work`, or `commit 1`.

### Pull Request

Push/publish the Sprint branch to the team's fork and open **one Pull Request** to the course repository.

```text
base repository: brenofeliix/mobile-development-2026-2
base branch: main
compare branch: team-XX/sprint-00
```

PR title:

```text
[Sprint 00] Team XX — Development Environment & Git Workflow
```

PR description:

```md
## Sprint
SPRINT 00 — Development Environment & Git Workflow

## Summary
Briefly describe what was implemented.

## Specification
Link N/A — Sprint 00 has no feature SPEC.

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

- [ ] Environment is ready.
- [ ] Android app builds and runs.
- [ ] Evidence is included.
- [ ] Sprint report is complete.
- [ ] Pull Request was submitted for instructor review.
