# Mobile Software Development

## 2026/2

Official repository for the **Mobile Software Development** course.

Throughout the semester, students will design, implement, validate, and evolve native Android applications using:

- Kotlin;
- Android Studio;
- Jetpack Compose;
- Git and GitHub;
- specification-driven development;
- AI-assisted development tools.

The course follows an incremental project-based approach. Each team develops the same application throughout the semester, adding new capabilities through successive Sprints.

---

## Development Workflow

The development process used in this course follows the cycle:

**SPEC → BUILD → VALIDATE → EXPLAIN → COMMIT**

Each submitted increment must be traceable from specification to implementation and validation.

### SPEC

Define what must be implemented.

Each feature must have:

- clear context;
- functional requirements;
- constraints;
- acceptance criteria;
- defined scope.

### BUILD

Implement only what is required by the current Sprint and specification.

Students should avoid adding unnecessary functionality that has not yet been specified.

### VALIDATE

Build and execute the application.

The team must verify that all acceptance criteria defined in the corresponding specification are satisfied.

### EXPLAIN

Every team member must be able to explain:

- what was implemented;
- where the requirement is implemented in the code;
- how the solution works;
- how the acceptance criteria were validated;
- how AI-assisted tools were used, when applicable.

### COMMIT

Only validated work should be committed and submitted.

---

## Sprint Workflow

For every Sprint, teams must follow this sequence:

1. Read the Sprint instructions.
2. Create the Sprint branch.
3. Review the current product state.
4. Create or update the required specification.
5. Implement the requested functionality.
6. Use documentation and AI-assisted tools when appropriate.
7. Build the Android application.
8. Run the application on an emulator or physical Android device.
9. Validate all acceptance criteria.
10. Collect the required evidence.
11. Update the Sprint documentation.
12. Commit the validated changes.
13. Push the branch to GitHub.
14. Open a Pull Request.
15. Wait for instructor review.

---

## Repository Structure

The repository is organized as follows:

```text
mobile-development-2026-2/
├── docs/
│   ├── ai-policy.md
│   └── methodology.md
│
├── projects/
│   ├── README.md
│   ├── team-01/
│   ├── team-02/
│   └── ...
│
├── sprints/
│   ├── SPRINT-00.md
│   ├── SPRINT-01.md
│   ├── SPRINT-02.md
│   └── ...
│
├── templates/
│   └── SPEC-TEMPLATE.md
│
└── README.md
```

### `docs/`

Course methodology, policies, and supporting documentation.

### `projects/`

Student applications and Sprint submissions.

Each team must work only inside its own directory:

```text
projects/team-XX/
```

### `sprints/`

Official instructions for each Sprint.

Students must always read the corresponding Sprint document before starting development.

### `templates/`

Reusable templates used throughout the course.

The main specification template is:

```text
templates/SPEC-TEMPLATE.md
```

---

## Team Project Structure

Each team should maintain its project using the following structure:

```text
projects/team-XX/
├── app/
│   └── Android project
│
├── docs/
│   └── specs/
│       ├── SPEC-001.md
│       ├── SPEC-002.md
│       └── ...
│
├── evidence/
│   ├── sprint-00/
│   ├── sprint-01/
│   └── ...
│
├── SPRINT-00.md
├── SPRINT-01.md
└── ...
```

The Android Studio project must remain inside:

```text
projects/team-XX/app/
```

---

## Git and GitHub Submission Rules

All Sprint submissions must use Git and GitHub.

### Branch Naming

Each Sprint must be developed in a dedicated branch.

Required format:

```text
team-XX/sprint-YY
```

Examples:

```text
team-03/sprint-01
team-07/sprint-04
team-10/sprint-07
```

Do not develop Sprint work directly on `main`.

---

## Commits

Commits should be meaningful and describe completed work.

Examples:

```text
docs: define SPEC-002 interaction requirements
feat: implement form validation
feat: add navigation between application screens
fix: correct invalid state handling
docs: add Sprint 04 validation evidence
```

Avoid vague commit messages such as:

```text
update
changes
final
done
test
new version
```

Students should commit logical increments rather than unrelated changes in a single commit.

---

## Pull Requests

Every Sprint must be submitted through a Pull Request.

The Pull Request must target:

```text
base: main
```

and use the corresponding Sprint branch as the source.

Recommended title format:

```text
[Sprint YY] Team XX — Sprint Title
```

Example:

```text
[Sprint 03] Team 05 — Navigation & Multiple Screens
```

Students must not merge their own Pull Requests.

The instructor will review the submission and may:

- approve the Pull Request;
- request changes;
- ask for additional evidence;
- ask team members to explain the implementation.

If changes are requested, students must continue working on the same Sprint branch.

New commits pushed to the branch will automatically update the existing Pull Request.

---

## Artificial Intelligence

The use of AI-assisted development tools is allowed.

Examples include tools that support:

- code generation;
- debugging;
- code explanation;
- documentation;
- specification refinement;
- test generation;
- API exploration;
- refactoring.

However, AI-generated output must never be accepted without review.

Students remain responsible for:

- understanding submitted code;
- checking generated code before using it;
- testing the implemented solution;
- identifying and fixing errors;
- validating acceptance criteria;
- verifying that generated code matches the Sprint specification;
- explaining the final implementation.

AI assistance does not transfer responsibility from the student to the tool.

---

## AI-Assisted Development Workflow

A recommended interaction with an LLM is:

```text
1. Provide the current specification.
2. Describe the existing project structure.
3. Ask for help with one specific task.
4. Review the proposed solution.
5. Adapt the solution to the project.
6. Build and run the application.
7. Validate the acceptance criteria.
8. Ask the LLM to explain unfamiliar code when necessary.
9. Correct any problems identified during validation.
```

A useful prompt structure is:

```text
I am developing an Android application using Kotlin and Jetpack Compose.

Current Sprint:
[SPRINT]

Current specification:
[SPECIFICATION]

Current implementation:
[RELEVANT CODE OR PROJECT CONTEXT]

Task:
[WHAT I NEED TO IMPLEMENT]

Constraints:
[SPRINT CONSTRAINTS]

Please:
1. explain the proposed solution;
2. provide only the code necessary for this task;
3. identify which requirement each part addresses;
4. explain how I can validate the acceptance criteria;
5. avoid implementing features outside the current Sprint.
```

Students should never submit code they are unable to explain.

---

## Validation Evidence

Each Sprint may require evidence demonstrating that the implementation works.

Evidence may include:

- screenshots;
- emulator execution;
- physical Android device execution;
- validation results;
- build results;
- application state before and after an interaction.

Evidence must be stored inside:

```text
projects/team-XX/evidence/sprint-YY/
```

Example:

```text
projects/team-04/evidence/sprint-03/navigation-home-details.png
```

---

## Sprint Documentation

Each team must maintain a Sprint document:

```text
projects/team-XX/SPRINT-YY.md
```

The document should include, when required:

- Sprint goal;
- implemented functionality;
- specification reference;
- validation results;
- evidence;
- AI usage;
- known limitations;
- Definition of Done.

---

## Definition of Done

A Sprint is considered complete only when:

- the requested functionality is implemented;
- the specification is complete;
- all acceptance criteria are validated;
- the application builds successfully;
- the application runs successfully;
- required evidence is included;
- Sprint documentation is complete;
- the team can explain the implementation;
- changes are committed;
- the branch is pushed;
- a Pull Request is submitted.

A working application alone is not sufficient if the Sprint documentation, specification, validation, or evidence is incomplete.

---

## Instructor Review

During review, the instructor may ask any team member to:

- explain a function;
- identify where a requirement is implemented;
- explain a Compose component;
- justify a technical decision;
- describe how AI was used;
- modify a small part of the implementation;
- demonstrate the application running;
- show how an acceptance criterion was validated.

The purpose is to verify authorship, understanding, and technical learning.

---

## Course Principle

The objective of this course is not only to produce a working Android application.

The objective is to learn how to develop software through a disciplined and traceable process:

```text
Problem
   ↓
Product
   ↓
Specification
   ↓
Implementation
   ↓
Validation
   ↓
Evidence
   ↓
Explanation
   ↓
Version Control
```

**Build software that works — and be able to explain why it works.**
