# Delete Task Feature — CI/CD Pipeline

**Branch:** `delete-task-feature`  
**Author:** Shreeya Malu  
**Project:** AI To-Do Task Tracker (Group DevOps Lab Project)

---

## What This Branch Does

This branch implements the **Delete Task** feature for the To-Do application, along with a full CI/CD pipeline using Jenkins, Maven, JUnit 5, Mockito, and Docker.

### Feature: Delete a Task
- A delete button appears on every task row in the UI
- Clicking it removes the task with a smooth animation
- If the deleted task had already been marked complete, its points are correctly deducted
- Backend `DELETE /delete_task/<id>` endpoint removes a task by ID

---

## Project Structure

```
delete-task-feature/
├── src/
│   ├── main/java/
│   │   ├── Task.java           # Task model (id + title)
│   │   └── TodoList.java       # deleteTask() logic
│   └── test/java/
│       └── TodoListTest.java   # JUnit 5 + Mockito tests (13 test cases)
├── index.html                  # Frontend (improved)
├── app.py                      # Flask backend
├── requirements.txt            # Python dependencies
├── pom.xml                     # Maven build config
├── Dockerfile                  # Docker image for Flask app
├── Jenkinsfile                 # CI/CD pipeline definition
└── README.md
```

---

## CI/CD Pipeline

```
Checkout → Build (Maven) → Test (JUnit 5 + Mockito) → Package → Docker Build → Docker Push → Deploy
```

### Stages

| Stage | Tool | What It Does |
|---|---|---|
| Checkout | Git / Jenkins | Pulls `delete-task-feature` branch |
| Build | Maven | Compiles `Task.java` and `TodoList.java` |
| Test | JUnit 5 + Mockito | Runs 13 unit tests; publishes results in Jenkins |
| Package | Maven | Packages compiled classes into a JAR |
| Docker Build | Docker | Builds image from `Dockerfile` |
| Docker Push | Docker Hub | Pushes image (free tier) |
| Deploy | Docker | Runs container on port 5000 |

---

## Running Tests Locally

### Prerequisites
- Java 11+
- Maven 3.6+

```bash
# Run all JUnit tests
mvn test

# View test report
open target/surefire-reports/TodoListTest.txt
```

### Test Cases (13 total)

| # | Test | Covers |
|---|---|---|
| 1 | `testDeleteTask_reducesListSize` | Size decreases after delete |
| 2 | `testDeleteTask_removesCorrectTask` | Correct task is removed |
| 3 | `testDeleteTask_returnsTrueOnSuccess` | Returns `true` on valid delete |
| 4 | `testDeleteTask_returnsFalseWhenNotFound` | Returns `false` for missing ID |
| 5 | `testDeleteTask_listUnchangedWhenIdNotFound` | List unmodified on miss |
| 6 | `testDeleteTask_emptyListAfterDeletingLastTask` | Can empty the list |
| 7 | `testDeleteTask_onEmptyList` | Safe on empty list |
| 8 | `testDeleteTask_firstElement` | Deletes first item |
| 9 | `testDeleteTask_lastElement` | Deletes last item |
| 10 | `testDeleteTask_middleElement` | Deletes middle item |
| 11 | `testDeleteTask_callsRemoveOnce` *(Mockito)* | `remove()` called exactly once |
| 12 | `testDeleteTask_doesNotCallRemoveWhenIdMissing` *(Mockito)* | `remove()` never called on miss |
| 13 | `testTask_mockGetters` *(Mockito)* | Mock verifies `getId()` / `getTitle()` |

---

## Running with Docker (Free)

```bash
# Build the image
docker build -t todo-app-delete .

# Run (requires a .env file with GEMINI_API_KEY=your_key)
docker run -p 5000:5000 --env-file .env todo-app-delete

# App available at:
open http://localhost:5000
```

---

## Jenkins Setup

1. Install Jenkins locally (free): https://www.jenkins.io/download/
2. Install plugins: **Git**, **Pipeline**, **JUnit**, **Docker Pipeline**
3. Create a new **Pipeline** job
4. Under *Pipeline → Definition*, choose **Pipeline script from SCM**
5. Set SCM = Git, branch = `delete-task-feature`
6. Add Docker Hub credentials with ID `dockerhub-credentials`
7. Click **Build Now**

---

## Frontend Improvements (this branch)

| Fix | Description |
|---|---|
| ✅ Points | Subtasks = +2 pts, main task = +10 pts; deducted correctly on uncheck or delete |
| ✅ Completed | Done tasks get strikethrough + move to "Completed Today"; pending stay on top |
| ✅ Main task always added | Main task is added instantly before AI call — never lost on error/timeout |
| ✅ AI feedback | "Generating subtasks…" spinner shown; success/error messages displayed inline |

---

## Group Project Note

This branch covers **only the delete task feature**. Other features (add, edit, view) are developed on their respective branches by team members and are intentionally kept separate for this lab demonstration.
